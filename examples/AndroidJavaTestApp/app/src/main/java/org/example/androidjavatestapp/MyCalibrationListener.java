package org.example.androidjavatestapp;

import android.util.Log;

import com.gipstech.mdk.CalibrationListener4j;
import com.gipstech.mdk.CalibrationManager4j;

class MyCalibrationListener implements CalibrationListener4j {
    MyLocationListener listener;

    public MyCalibrationListener(MyLocationListener listener) {
        this.listener = listener;
    }

    @Override
    public void onProgress(int percentage, boolean enough) {
        Log.d("APP", "onProgress " + percentage);

        if (enough) {
            Log.d("APP", "Calibration completed");
            CalibrationManager4j.endCalibration();

            if (listener != null) {
                listener.target.startLocalization(listener);
            }
        }
    }
}