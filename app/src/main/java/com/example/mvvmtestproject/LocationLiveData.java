package com.example.mvvmtestproject;

import android.icu.text.Transliterator;
import android.location.LocationManager;

import androidx.lifecycle.LiveData;

public class LocationLiveData extends LiveData<String> {

    private LocationManager locationManager;
    public LocationLiveData() {


    }

    @Override
    protected void onActive() {
        super.onActive();
    }


    @Override
    protected void onInactive() {
        super.onInactive();
    }
}
