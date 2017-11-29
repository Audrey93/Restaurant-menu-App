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
 * Created by Amina PC on 23/06/2017.
 */

public class FragmentPredjelo2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_predjelo2_layout, container, false);
        TextView txt = (TextView) v.findViewById(R.id.predjelo2);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "James Fajardo.ttf");
        txt.setTypeface(font);
        return v;
    }
}
