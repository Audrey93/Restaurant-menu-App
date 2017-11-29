package com.example.aminapc.lonacipoklopac.Rez;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Fujitsu E751 on 24/05/2017.
 */

public class Rezervacija {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mRezervacija;
    private String mBrojmjesta;

    public Rezervacija()
    {
        this(UUID.randomUUID());
    }

    public Rezervacija(UUID id)
    {
        mId = id;
        mDate = new Date();
    }

    public UUID getId()
    {
        return mId;
    }
    public String getTitle()
    {
        return mTitle;
    }
    public void setTitle(String title)
    {
        mTitle = title;
    }

    public String getBrojUlaznica()
    {
        return mBrojmjesta;
    }
    public void setBrojUlaznica(String brojUlaznica)
    {
        mBrojmjesta = brojUlaznica;
    }

    public Date getDate()
    {
        return mDate;
    }
    public void setDate(Date date)
    {
        mDate = date;
    }
    public boolean isRezervacija()
    {
        return mRezervacija;
    }
    public void setRezervacija(boolean rezervacija)
    {
        mRezervacija = rezervacija;
    }
}