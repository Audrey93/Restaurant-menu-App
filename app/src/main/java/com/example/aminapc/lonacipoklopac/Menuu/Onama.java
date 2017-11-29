package com.example.aminapc.lonacipoklopac.Menuu;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.aminapc.lonacipoklopac.R;

public class Onama extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onama);

        Typeface myTypeFace = Typeface.createFromAsset(getAssets(),"Ellianarelle s Path.ttf");
        TextView myTextView = (TextView) findViewById(R.id.onama_naslov);
        myTextView.setTypeface(myTypeFace);


    }
}
