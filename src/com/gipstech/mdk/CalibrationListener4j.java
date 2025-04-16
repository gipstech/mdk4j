package com.gipstech.mdk;

/**
 * Java-compatible listener interface for receiving calibration progress updates.
 *
 * This interface is intended to be implemented in Java code and used as a bridge
 * with Kotlin-based calibration systems. It enables Java clients to receive real-time
 * progress updates and completion status during a calibration procedure.
 */
public interface CalibrationListener4j {
    void onProgress(int percentage, boolean enough);
}