package com.gipstech.mdk.spatial

import kotlinx.coroutines.runBlocking

/**
 * Java-facing wrapper class for a Kotlin [Floor] object.
 *
 * This class is designed to let Java code interact with Kotlin suspended methods by running
 * them in a blocking way, making it easier to use asynchronous Kotlin logic from Java.
 *
 * @param wrapped The underlying Kotlin [Floor] instance being wrapped.
 */
class Floor4j(val wrapped: Floor) {
    fun requestImage() = runBlocking {
        wrapped.requestImage()
    }

    fun requestImageFile() = runBlocking {
        wrapped.requestImageFile()
    }
}