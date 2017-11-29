package com.example.aminapc.lonacipoklopac.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class BaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "RezervacijeBase.db";
    public BaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }
    @Override

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + DbSchema.RezervacijeTable.NAME+ "(" +
                " _id integer primary key autoincrement, " +
                DbSchema.RezervacijeTable.Cols.UUID + ", " +
                DbSchema.RezervacijeTable.Cols.TITLE + ", " +
                DbSchema.RezervacijeTable.Cols.DATE + ", " +
                DbSchema.RezervacijeTable.Cols.REZERVACIJA + ", " +
                DbSchema.RezervacijeTable.Cols.BROJMJESTA +
                ")"
        );
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
