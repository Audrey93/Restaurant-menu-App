package com.example.aminapc.lonacipoklopac.Rez;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.aminapc.lonacipoklopac.R;

import java.util.List;
import java.util.UUID;

/**
 * Created by Fujitsu E751 on 24/05/2017.
 */
public class RezervacijaPagerActivity extends AppCompatActivity {

    private static final String EXTRA_REZERVACIJA_ID  =
            "com.bignerdranch.android.criminalintent.crime_id";

    private ViewPager mViewPager;
    private List<Rezervacija> aMRezervacijas;

    public static Intent newIntent(Context packageContext, UUID rezervacijaId) {
        Intent intent = new Intent(packageContext, RezervacijaPagerActivity.class);
        intent.putExtra(EXTRA_REZERVACIJA_ID, rezervacijaId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezervacija_pager);

        UUID rezervacijaId = (UUID) getIntent()
                .getSerializableExtra(EXTRA_REZERVACIJA_ID );

        mViewPager = (ViewPager) findViewById(R.id.rezervacija_view_pager);
        aMRezervacijas = RezervacijaLab.get(this).uzmiRezervacije();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Rezervacija rezervacija = aMRezervacijas.get(position);
                return RezervacijaFragment.newInstance(rezervacija.getId());
            }
            @Override
            public int getCount() {
                return aMRezervacijas.size();
            }
        });

        for (int i = 0; i < aMRezervacijas.size(); i++) {
            if (aMRezervacijas.get(i).getId().equals(rezervacijaId)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}