package com.gipstech.mdk.internal

import com.gipstech.mdk.CalibrationListener
import com.gipstech.mdk.CalibrationListener4j

/**
 * Internal wrapper class used to adapt a [CalibrationListener4j] (Java interface)
 * to the Kotlin-facing [CalibrationListener] interface.
 *
 * This class acts as a bridge between Kotlin and Java code, enabling interoperability:
 * when a component expects a [CalibrationListener] but the logic is implemented
 * using a Java-compatible [CalibrationListener4j], this wrapper can be used.
 *
 * The [onProgress] method is invoked asynchronously during a calibration process
 * and simply delegates the received values to the underlying Java listener.
 *
 * @param listener An instance implementing the Java interface [CalibrationListener4j].
 */
internal class CalibrationListenerWrapper(private val listener: CalibrationListener4j): CalibrationListener {
    override suspend fun onProgress(percentage: Int, enough: Boolean) {
        listener.onProgress(percentage, enough)
    }
}