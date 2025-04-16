package com.gipstech.mdk;

import com.gipstech.mdk.spatial.Building4j;

/**
 * Java-compatible listener interface for receiving location-related updates.
 *
 * This interface is designed for use in Java codebases to handle events emitted by
 * the GiPStech localization system.
 *
 * Default methods are provided for optional event handling without requiring full implementation.
 */
public interface LocationListener4j {
    void onCalibrationRequest(CalibrationType[] types);
    void onException(GiPStechException exception);
    default void onLevelChanged(int level) { }
    default void onBuildingChanged(Building4j building) { }
    default void onLocationUpdated(Location location) { }
    default void onGeofenceEnter(String name, float confidence) { }
    default void onGeofenceExit(String name, float confidence) { }
}