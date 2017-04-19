package com.example.android.quakereport;

import java.util.Date;

/**
 * Created by calencastro on 26/03/2017.
 */

public class EarthquakeList {

    private Double mMag;
    private String mLocation;
    private long mDate;

    public EarthquakeList (Double mag, String location, long date){
        mMag = mag;
        mLocation = location;
        mDate = date;
    }

    public Double getMag(){ return mMag;}
    public String getLocation(){return mLocation;}
    public long getDate() { return mDate;}

}
