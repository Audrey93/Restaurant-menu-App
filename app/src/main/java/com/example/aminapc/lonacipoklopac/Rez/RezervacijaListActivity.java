package com.example.aminapc.lonacipoklopac.Rez;

import android.support.v4.app.Fragment;

/**
 * Created by Fujitsu E751 on 24/05/2017.
 */


public class RezervacijaListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new RezervacijaListFragment();
    }
}