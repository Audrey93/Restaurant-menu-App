package com.example.aminapc.lonacipoklopac.Galery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.aminapc.lonacipoklopac.Galery.ImageAdapter;
import com.example.aminapc.lonacipoklopac.R;

public class FullImageView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image_view);
        Intent i=getIntent();
        int position=i.getExtras().getInt("id");
        ImageAdapter imageAdapter= new ImageAdapter(this);
        ImageView imageView=(ImageView) findViewById(R.id.galerijaSlika);
        imageView.setImageResource(imageAdapter.images[position]);
    }
}
