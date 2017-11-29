package com.example.aminapc.lonacipoklopac.Jelovnik;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aminapc.lonacipoklopac.R;

/**
 * Created by Fujitsu E751 on 18/06/2017.
 */

public class FragmentThree extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_three_layout, container, false);
        TextView txt = (TextView) v.findViewById(R.id.textView3);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "James Fajardo.ttf");
        txt.setTypeface(font);
        return v;
    }
}
