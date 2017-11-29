package com.example.aminapc.lonacipoklopac.Jelovnik;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Amina PC on 23/06/2017.
 */

public class PagerAdapterGlavnoJelo extends FragmentPagerAdapter {

    public PagerAdapterGlavnoJelo (FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int arg0){

        switch (arg0) {
            case 0:
                return new FragmentGlavnoJelo1();
            case 1:
                return new FragmentGlavnoJelo2();
            case 2:
                return new FragmentGlavnoJelo3();
            case 3:
                return new FragmentGlavnoJelo4();
            case 4:
                return new FragmentGlavnoJelo5();
            default:
                break;
        }

        return null;
    }

    @Override
    public int getCount() {
        return 5;
    }
}

