package com.gipstech.mdk.spatial

import com.gipstech.mdk.LocationListener4j
import com.gipstech.mdk.internal.LocationListenerWrapper
import kotlinx.coroutines.runBlocking

/**
 * Java-facing wrapper class for a Kotlin [Building] object.
 *
 * This class is designed to let Java code interact with Kotlin suspended methods by running
 * them in a blocking way, making it easier to use asynchronous Kotlin logic from Java.
 *
 * @param wrapped The underlying Kotlin [Building] instance being wrapped.
 */
class Building4j(val wrapped: Building): Place4j() {
    override fun startLocalization(listener: LocationListener4j) = runBlocking {
        wrapped.startLocalization(LocationListenerWrapper(listener))
    }

    override fun stopLocalization() = runBlocking {
        wrapped.stopLocalization()
    }

    fun getFloor4j(i: Int): Floor4j {
        return Floor4j(wrapped.floors[i])
    }
}