package com.example.aminapc.lonacipoklopac.Rez;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.aminapc.lonacipoklopac.database.BaseHelper;
import com.example.aminapc.lonacipoklopac.database.DbSchema;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Fujitsu E751 on 24/05/2017.
 */

public class RezervacijaLab {
    private Context mContext;
    private SQLiteDatabase mDatabase;

    private static RezervacijaLab sRezervacijaLab;
    public static RezervacijaLab get(Context context) {
        if (sRezervacijaLab == null) {
            sRezervacijaLab = new RezervacijaLab(context);
        }
        return sRezervacijaLab;
    }
    private RezervacijaLab(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new BaseHelper(mContext)
                .getWritableDatabase();
    }
    ////umetanje redova
    public void addCrime(Rezervacija c) {
        ContentValues values = getContentValues(c);
        mDatabase.insert(DbSchema.RezervacijeTable.NAME, null, values);

    }

    public List<Rezervacija> uzmiRezervacije() {
        List<Rezervacija> rezervacija = new ArrayList<>();
        RezervacijaCursorWrapper cursor = queryCrimes(null, null);
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                rezervacija.add(cursor.getRezervacija());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return rezervacija;
    }

    public Rezervacija getCrime(UUID id) {
        RezervacijaCursorWrapper cursor = queryCrimes(
                DbSchema.RezervacijeTable.Cols.UUID + " = ?",
                new String[] { id.toString() }
        );
        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getRezervacija();
        } finally {
            cursor.close();
        }
    }

    public void updateCrime(Rezervacija rezervacija) {
        String uuidString = rezervacija.getId().toString();
        ContentValues values = getContentValues(rezervacija);
        mDatabase.update(DbSchema.RezervacijeTable.NAME, values,
                DbSchema.RezervacijeTable.Cols.UUID + " = ?",
                new String[] { uuidString });
    }
    private RezervacijaCursorWrapper queryCrimes(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                DbSchema.RezervacijeTable.NAME,
                null, // columns - null selects all columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null // orderBy
        );
        return new RezervacijaCursorWrapper(cursor);
    }
    //////   Creating a ContentValues  /////////
    private static ContentValues getContentValues(Rezervacija rezervacija) {
        ContentValues values = new ContentValues();
        values.put(DbSchema.RezervacijeTable.Cols.UUID, rezervacija.getId().toString());
        values.put(DbSchema.RezervacijeTable.Cols.TITLE, rezervacija.getTitle());
        values.put(DbSchema.RezervacijeTable.Cols.BROJMJESTA, rezervacija.getBrojUlaznica());
        values.put(DbSchema.RezervacijeTable.Cols.DATE, rezervacija.getDate().getTime());
        values.put(DbSchema.RezervacijeTable.Cols.REZERVACIJA, rezervacija.isRezervacija() ? 1 : 0);
        return values;
    }


}
