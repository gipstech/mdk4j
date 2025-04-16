package org.example.androidjavatestapp;

import android.util.Log;

import androidx.annotation.NonNull;

import com.gipstech.mdk.CalibrationManager4j;
import com.gipstech.mdk.CalibrationType;
import com.gipstech.mdk.GiPStechException;
import com.gipstech.mdk.Location;
import com.gipstech.mdk.LocationListener4j;
import com.gipstech.mdk.spatial.Building4j;
import com.gipstech.mdk.spatial.Place4j;

class MyLocationListener implements LocationListener4j {
    Place4j target;

    MyLocationListener(Place4j target) {
        this.target = target;
    }

    @Override
    public void onCalibrationRequest(@NonNull CalibrationType[] types) {
        Log.d("APP", "onCalibrationRequest " + types[0]);
        CalibrationManager4j.beginCalibration(types[0], new MyCalibrationListener(this));
    }

    @Override
    public void onException(@NonNull GiPStechException exception) {
        Log.d("APP", "onException " + exception.getMessage());
    }

    public void onLevelChanged(int level) {
        Log.d("APP", "onLevelChanged " + level);
    }

    @Override
    public void onBuildingChanged(Building4j building) {
        if (building != null) {
            Log.d("APP", "onBuildingChanged " + building.getWrapped().getName());
        } else {
            Log.d("APP", "onBuildingChanged OUTDOOR");
        }
    }

    @Override
    public void onLocationUpdated(Location location) {
        Log.d("APP", "onLocationUpdated " + location.getLongitude() + " " + location.getLatitude());
    }

    public void onGeofenceEnter(String name, float confidence) {
        Log.d("APP", "onGeofenceEnter " + name);
    }

    public void onGeofenceExit(String name, float confidence) {
        Log.d("APP", "onGeofenceExit " + name);
    }
}