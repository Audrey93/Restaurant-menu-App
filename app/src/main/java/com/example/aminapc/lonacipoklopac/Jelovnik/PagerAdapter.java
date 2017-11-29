package com.example.aminapc.lonacipoklopac.Jelovnik;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Fujitsu E751 on 18/06/2017.
 */

public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int arg0){

        switch (arg0) {
            case 0:
                return new FragmentOne();
            case 1:
                return new FragmentTwo();
            case 2:
                return new FragmentThree();
            case 3:
                return new FragmentFour();
            case 4:
                return new FragmentFive();
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
