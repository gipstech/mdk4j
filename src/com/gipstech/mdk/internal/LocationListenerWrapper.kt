package com.gipstech.mdk.internal

import com.gipstech.mdk.CalibrationType
import com.gipstech.mdk.Location
import com.gipstech.mdk.LocationListener
import com.gipstech.mdk.LocationListener4j
import com.gipstech.mdk.spatial.Building
import com.gipstech.mdk.spatial.Building4j

/**
 * Internal wrapper class that adapts a Java-facing [LocationListener4j] interface
 * to the Kotlin-facing [LocationListener] interface.
 *
 * This wrapper is primarily used to bridge interoperability between Kotlin and Java code,
 * allowing Java listeners to be seamlessly integrated where a [LocationListener] is expected.
 *
 * Each callback method in this class simply delegates the call to the corresponding
 * method in the wrapped [LocationListener4j] instance.
 *
 * Special handling is applied in [onBuildingChanged]: if a [Building] is not null,
 * it is wrapped in a [Building4j] object to adapt the type for the Java-side listener.
 *
 * This design ensures minimal duplication and clean separation between platform interfaces.
 *
 * @param listener An implementation of the Java [LocationListener4j] interface.
 */
internal class LocationListenerWrapper(private val listener: LocationListener4j): LocationListener {
    override suspend fun onCalibrationRequest(types: Array<CalibrationType>) {
        listener.onCalibrationRequest(types)
    }

    override suspend fun onException(exception: com.gipstech.mdk.GiPStechException) {
        listener.onException(exception)
    }

    override suspend fun onLevelChanged(level: Int) {
        listener.onLevelChanged(level)
    }

    override suspend fun onBuildingChanged(building: Building?) {
        if (building != null) {
            listener.onBuildingChanged(Building4j(building))
        } else {
            listener.onBuildingChanged(null)
        }
    }

    override suspend fun onLocationUpdated(location: Location) {
        listener.onLocationUpdated(location)
    }

    override suspend fun onGeofenceEnter(name: String, confidence: Float) {
        listener.onGeofenceEnter(name, confidence)
    }

    override suspend fun onGeofenceExit(name: String, confidence: Float) {
        listener.onGeofenceExit(name, confidence)
    }
}