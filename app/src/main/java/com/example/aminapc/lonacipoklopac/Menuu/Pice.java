package com.example.aminapc.lonacipoklopac.Menuu;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.example.aminapc.lonacipoklopac.Jelovnik.PagerAdapterPice;
import com.example.aminapc.lonacipoklopac.R;

public class Pice extends FragmentActivity {
    ViewPager aViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pice);


        aViewPager = (ViewPager) findViewById(R.id.pager_pice);
        android.support.v4.view.PagerAdapter adapter = new PagerAdapterPice(getSupportFragmentManager());
        aViewPager.setAdapter(adapter);






    }
}
