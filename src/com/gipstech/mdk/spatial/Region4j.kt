package com.gipstech.mdk.spatial

import com.gipstech.mdk.LocationListener4j
import com.gipstech.mdk.internal.LocationListenerWrapper
import kotlinx.coroutines.runBlocking

/**
 * Java-facing wrapper class for a Kotlin [Region] object.
 *
 * This class is designed to let Java code interact with Kotlin suspended methods by running
 * them in a blocking way, making it easier to use asynchronous Kotlin logic from Java.
 *
 * @param wrapped The underlying Kotlin [Region] instance being wrapped.
 */
class Region4j(val wrapped: Region): Place4j() {
    override fun startLocalization(listener: LocationListener4j) = runBlocking {
        wrapped.startLocalization(LocationListenerWrapper(listener))
    }

    override fun stopLocalization() = runBlocking {
        wrapped.stopLocalization()
    }

    fun requestAdditionalArea(southWest: Coordinates, northEast: Coordinates, fallback: Boolean) = runBlocking {
        wrapped.requestAdditionalArea(southWest, northEast, fallback)
    }

    fun requestAdditionalArea(swLongitude: Double, swLatitude: Double, neLongitude: Double, neLatitude: Double, fallback: Boolean) = runBlocking {
        wrapped.requestAdditionalArea(swLongitude, swLatitude, neLongitude, neLatitude, fallback)
    }

    fun getBuilding4j(i: Int): Building4j {
        return Building4j(wrapped.buildings[i])
    }
}