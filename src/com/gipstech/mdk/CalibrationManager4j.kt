package com.gipstech.mdk

import com.gipstech.mdk.internal.CalibrationListenerWrapper
import kotlinx.coroutines.runBlocking

/**
 * Java-facing facade for the [CalibrationManager] class.
 *
 * This class provides static methods that wrap coroutine-based SDK functions
 * using 'runBlocking', allowing them to be invoked from Java code in a blocking way.
 */
class CalibrationManager4j {
    companion object {
        @JvmStatic
        fun beginCalibration(type: CalibrationType, listener: CalibrationListener4j) = runBlocking {
            CalibrationManager.beginCalibration(type, CalibrationListenerWrapper(listener))
        }

        @JvmStatic
        fun endCalibration() = runBlocking {
            CalibrationManager.endCalibration()
        }

        @JvmStatic
        fun abortCalibration() = runBlocking {
            CalibrationManager.abortCalibration()
        }
    }
}