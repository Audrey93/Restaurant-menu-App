package com.example.aminapc.lonacipoklopac.Rez;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aminapc.lonacipoklopac.R;

import java.util.List;

/**
 * Created by Fujitsu E751 on 24/05/2017.
 */
public class RezervacijaListFragment extends Fragment {
    private static final String SAVED_SUBTITLE_VISIBLE = "subtitle";
    private RecyclerView mCrimeRecyclerView;
    private CrimeAdapter mAdapter;
    private boolean mSubtitleVisible;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rezervacija_list, container, false);
        mCrimeRecyclerView = (RecyclerView) view
                .findViewById(R.id.rezervacija_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        if (savedInstanceState != null) {
            mSubtitleVisible = savedInstanceState.getBoolean(SAVED_SUBTITLE_VISIBLE);
        }
        updateUI();
        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(SAVED_SUBTITLE_VISIBLE, mSubtitleVisible);
    }
    /////////menu/////////////////////////////////////////////
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_rezervacija_list, menu);

        MenuItem subtitleItem = menu.findItem(R.id.show_subtitle);
        if (mSubtitleVisible) {
            subtitleItem.setTitle(R.string.hide_subtitle);
        } else {
            subtitleItem.setTitle(R.string.show_subtitle);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.rezervisi:
                Rezervacija rezervacija = new Rezervacija();
                RezervacijaLab.get(getActivity()).addCrime(rezervacija);
                Intent intent = RezervacijaPagerActivity
                        .newIntent(getActivity(), rezervacija.getId());
                startActivity(intent);
                return true;
            case R.id.show_subtitle:
                mSubtitleVisible = !mSubtitleVisible;
                getActivity().invalidateOptionsMenu();
                updateSubtitle();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateSubtitle() {
        RezervacijaLab rezervacijaLab = RezervacijaLab.get(getActivity());
        int rezervacijaCount = rezervacijaLab.uzmiRezervacije().size();
        String subtitle = getString(R.string.subtitle_format, rezervacijaCount);
        if (!mSubtitleVisible) {
            subtitle = null;
        }
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.getSupportActionBar().setSubtitle(subtitle);
    }

    ///////////////menu//////////////////////////////////
    private void updateUI() {
        RezervacijaLab rezervacijaLab = RezervacijaLab.get(getActivity());
        List<Rezervacija> rezervacijas = rezervacijaLab.uzmiRezervacije();
        if (mAdapter == null) {
            mAdapter = new CrimeAdapter(rezervacijas);
            mCrimeRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setCrimes(rezervacijas);
            mAdapter.notifyDataSetChanged();
        }
        updateSubtitle();
    }

    private class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTitleTextView;
        private TextView mDateTextView;
        private Rezervacija aMRezervacija;
        private ImageView mSolvedImageView;


        public CrimeHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_rezervacija, parent, false));
            itemView.setOnClickListener(this);
            mTitleTextView = (TextView) itemView.findViewById(R.id.crime_title);
            mDateTextView = (TextView) itemView.findViewById(R.id.crime_date);
            mSolvedImageView = (ImageView) itemView.findViewById(R.id.crime_solved);

        }
        public void bind(Rezervacija rezervacija) {
            aMRezervacija = rezervacija;
            mTitleTextView.setText(aMRezervacija.getTitle());
            mDateTextView.setText(aMRezervacija.getDate().toString().substring(0, 10));
            mSolvedImageView.setVisibility(rezervacija.isRezervacija() ? View.VISIBLE : View.GONE);
        }

        @Override
        public void onClick(View view) {
            Intent intent = RezervacijaPagerActivity.newIntent(getActivity(), aMRezervacija.getId());
            startActivity(intent);
        }
    }
    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder> {
        private List<Rezervacija> aMRezervacijas;



        public CrimeAdapter(List<Rezervacija> rezervacijas) {
            aMRezervacijas = rezervacijas;
        }


        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new CrimeHolder(layoutInflater, parent);
        }
        @Override
        public void onBindViewHolder(CrimeHolder holder, int position) {
            Rezervacija rezervacija = aMRezervacijas.get(position);
            holder.bind(rezervacija);
        }
        @Override
        public int getItemCount() {
            return aMRezervacijas.size();
        }
        public void setCrimes(List<Rezervacija> rezervacijas) {
            aMRezervacijas = rezervacijas;
        }
    }

}