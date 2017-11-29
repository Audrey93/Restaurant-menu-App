package com.example.aminapc.lonacipoklopac.Menuu;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.example.aminapc.lonacipoklopac.R;

public class Desert extends FragmentActivity {
    ViewPager aViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desert);


        aViewPager = (ViewPager) findViewById(R.id.pager);
        PagerAdapter adapter = new com.example.aminapc.lonacipoklopac.Jelovnik.PagerAdapter(getSupportFragmentManager());
        aViewPager.setAdapter(adapter);






}
    }

