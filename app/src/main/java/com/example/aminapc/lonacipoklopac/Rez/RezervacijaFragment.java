package com.example.aminapc.lonacipoklopac.Rez;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.example.aminapc.lonacipoklopac.R;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Fujitsu E751 on 24/05/2017.
 */

public class RezervacijaFragment extends Fragment {
    private static final String ARG_CRIME_ID = "rezervacija_id";
    private static final String DIALOG_DATE = "DialogDate";

    private static final int REQUEST_DATE = 0;

    private Rezervacija aMRezervacija;
    private EditText mTitleField;
    private EditText mBrojUlaznica;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;

    public static RezervacijaFragment newInstance(UUID rezervacijaId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_CRIME_ID, rezervacijaId);
        RezervacijaFragment fragment = new RezervacijaFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID rezervacijaId = (UUID) getArguments().getSerializable(ARG_CRIME_ID);
        aMRezervacija = RezervacijaLab.get(getActivity()).getCrime(rezervacijaId);
    }

    @Override
    public void onPause() {
        super.onPause();
        RezervacijaLab.get(getActivity())
                .updateCrime(aMRezervacija);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_rezervacija, container, false);

        mTitleField = (EditText) v.findViewById(R.id.crime_title);
        mBrojUlaznica = (EditText) v.findViewById(R.id.broj_ulaznica);
        mTitleField.setText(aMRezervacija.getTitle());
        mBrojUlaznica.setText(aMRezervacija.getBrojUlaznica());

        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence s, int start, int count, int after) {
// This space intentionally left blank
            }
            @Override
            public void onTextChanged(
                    CharSequence s, int start, int before, int count) {
                aMRezervacija.setTitle(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {
// This one too
            }
        });

        mBrojUlaznica.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence s, int start, int count, int after) {
// This space intentionally left blank
            }
            @Override
            public void onTextChanged(
                    CharSequence s, int start, int before, int count) {
                aMRezervacija.setBrojUlaznica(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {
// This one too
            }
        });

        mDateButton = (Button) v.findViewById(R.id.crime_date);
        updateDate();
        mDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                DatePickerFragment dialog = DatePickerFragment
                        .newInstance(aMRezervacija.getDate());
                dialog.setTargetFragment(RezervacijaFragment.this, REQUEST_DATE);
                dialog.show(manager, DIALOG_DATE);
            }
        });
        mSolvedCheckBox = (CheckBox)v.findViewById(R.id.crime_solved);
        mSolvedCheckBox.setChecked(aMRezervacija.isRezervacija());
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                aMRezervacija.setRezervacija(isChecked);
            }
        });
        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }
        if (requestCode == REQUEST_DATE) {
            Date date = (Date) data
                    .getSerializableExtra(DatePickerFragment.EXTRA_DATE);
            aMRezervacija.setDate(date);
            updateDate();
        }
    }

    private void updateDate() {
        mDateButton.setText(aMRezervacija.getDate().toString().substring(0, 10));
    }
}
