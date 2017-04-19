package com.example.android.quakereport;

import java.util.Date;

/**
 * Created by calencastro on 26/03/2017.
 */

public class EarthquakeList {

    private Double mMag;
    private String mLocation;
    private long mDate;
    private String mURL;

    public EarthquakeList (Double mag, String location, long date, String url){
        mMag = mag;
        mLocation = location;
        mDate = date;
        mURL = url;
    }

    public Double getMag(){ return mMag;}
    public String getLocation(){return mLocation;}
    public long getDate() { return mDate;}
    public String getURL(){return mURL;}

}
