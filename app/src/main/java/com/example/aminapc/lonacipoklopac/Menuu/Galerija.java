package com.example.aminapc.lonacipoklopac.Menuu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import com.example.aminapc.lonacipoklopac.Galery.FullImageView;
import com.example.aminapc.lonacipoklopac.Galery.ImageAdapter;
import com.example.aminapc.lonacipoklopac.R;

public class Galerija extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galerija);
        GridView gridView=(GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapter(this));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                                            {
                                                Intent i=new Intent (getApplicationContext(),FullImageView.class);
                                                i.putExtra("id",position);
                                                startActivity(i);
                                            }
                                        }

        );
        Button b;
    }
}