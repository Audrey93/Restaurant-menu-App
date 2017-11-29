package com.example.aminapc.lonacipoklopac.Rez;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class RezervacijaActivity extends SingleFragmentActivity {

    private static final String EXTRA_REZERVACIJA_ID =
            "com.bignerdranch.android.criminalintent.crime_id";

    public static Intent newIntent(Context packageContext, UUID rezervacijaId) {
        Intent intent = new Intent(packageContext, RezervacijaActivity.class);
        intent.putExtra(EXTRA_REZERVACIJA_ID, rezervacijaId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        UUID rezervacijaId = (UUID) getIntent()
                .getSerializableExtra(EXTRA_REZERVACIJA_ID);
        return RezervacijaFragment.newInstance(rezervacijaId);
    }

}
