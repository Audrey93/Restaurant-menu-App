package com.example.aminapc.lonacipoklopac.Menuu;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.example.aminapc.lonacipoklopac.Jelovnik.PagerAdapterPredjelo;
import com.example.aminapc.lonacipoklopac.R;

public class Predjelo extends FragmentActivity {
    ViewPager aViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predjelo);


        aViewPager = (ViewPager) findViewById(R.id.pager_predjelo);
        android.support.v4.view.PagerAdapter adapter = new PagerAdapterPredjelo(getSupportFragmentManager());
        aViewPager.setAdapter(adapter);






    }
}