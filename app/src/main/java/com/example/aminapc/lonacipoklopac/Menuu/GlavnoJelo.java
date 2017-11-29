package com.example.aminapc.lonacipoklopac.Menuu;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.example.aminapc.lonacipoklopac.Jelovnik.PagerAdapterGlavnoJelo;
import com.example.aminapc.lonacipoklopac.R;

public class GlavnoJelo extends FragmentActivity {
    ViewPager aViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glavno_jelo);


        aViewPager = (ViewPager) findViewById(R.id.pager_glavno_jelo);
        android.support.v4.view.PagerAdapter adapter = new PagerAdapterGlavnoJelo(getSupportFragmentManager());
        aViewPager.setAdapter(adapter);






    }
}