package com.gipstech.mdk.spatial

import com.gipstech.mdk.LocationListener4j
import com.gipstech.mdk.LocationSession

/**
 * Java-facing wrapper class for a Kotlin [Place] object.
 *
 * This class is designed to let Java code interact with Kotlin suspended methods by running
 * them in a blocking way, making it easier to use asynchronous Kotlin logic from Java.
 */
abstract class Place4j {
    abstract fun startLocalization(listener: LocationListener4j): LocationSession
    abstract fun stopLocalization()
}