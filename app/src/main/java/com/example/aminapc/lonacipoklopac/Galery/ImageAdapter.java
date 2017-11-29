package com.example.aminapc.lonacipoklopac.Galery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.aminapc.lonacipoklopac.R;

/**
 * Created by Amina PC on 23/06/2017.
 */

public class ImageAdapter extends BaseAdapter {

    private Context context;
    public Integer[] images = {
            R.drawable.slika0,
            R.drawable.slika1,
            R.drawable.slika2,
            R.drawable.slika3,
            R.drawable.slika4,
            R.drawable.slika5,
            R.drawable.slika6,
            R.drawable.slika7,
            R.drawable.slika8,
            R.drawable.slika9,
            R.drawable.slika10,
            R.drawable.slika11



    };
    public ImageAdapter (Context c){
        context=c;
    }



    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView=new ImageView(context);
        imageView.setImageResource(images[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(256,256));

        return imageView;
    }
}
