package com.gipstech.mdk

import kotlinx.coroutines.runBlocking

/**
 * Java-compatible facade for the [GiPStech] class.
 *
 * This class provides static methods that wrap coroutine-based SDK functions
 * using 'runBlocking', allowing them to be invoked from Java code in a blocking way.
 */
class GiPStech4j {
    companion object {
        @JvmStatic
        fun init(devKey: String, context: Any?) = runBlocking {
            GiPStech.init(devKey, context = context)
        }

        @JvmStatic
        fun init(devKey: String, tag: String, context: Any?) = runBlocking {
            GiPStech.init(devKey, tag, context)
        }

        @JvmStatic
        fun requestAuthentication() = runBlocking {
            GiPStech.requestAuthentication()
        }
    }
}