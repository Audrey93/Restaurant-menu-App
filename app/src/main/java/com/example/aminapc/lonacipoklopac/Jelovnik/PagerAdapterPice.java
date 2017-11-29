package com.example.aminapc.lonacipoklopac.Jelovnik;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Amina PC on 23/06/2017.
 */

public class PagerAdapterPice extends FragmentPagerAdapter {

    public PagerAdapterPice(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int arg0){

        switch (arg0) {
            case 0:
                return new FragmentPice1();
            case 1:
                return new FragmentPice2();
            case 2:
                return new FragmentPice3();
            case 3:
                return new FragmentPice4();
            case 4:
                return new FragmentPice5();
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

