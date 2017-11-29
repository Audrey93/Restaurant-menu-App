package com.example.aminapc.lonacipoklopac.Menuu;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.aminapc.lonacipoklopac.R;
import com.example.aminapc.lonacipoklopac.Rez.RezervacijaListActivity;

public class Meni extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meni);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.meni, menu);
        return true;


    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.predjelo) {
            Intent intent = new Intent(Meni.this, Predjelo.class);
            startActivity(intent);
        } else if (id == R.id.glavnojelo) {
            Intent intent = new Intent(Meni.this, GlavnoJelo.class);
            startActivity(intent);


        } else if (id == R.id.desert) {
            Intent intent = new Intent(Meni.this, Desert.class);
            startActivity(intent);

        } else if (id == R.id.pice) {
            Intent intent = new Intent(Meni.this, Pice.class);
            startActivity(intent);

        } else if (id == R.id.naruci) {
            Intent intent = new Intent(Meni.this, RezervacijaListActivity.class);
            startActivity(intent);


        } else if (id == R.id.galerija) {
            Intent intent = new Intent(Meni.this, Galerija.class);
            startActivity(intent);
        }
        else if (id == R.id.onama) {
            Intent intent = new Intent(Meni.this, Onama.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
