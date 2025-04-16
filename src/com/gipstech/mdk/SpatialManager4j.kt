package com.gipstech.mdk

import com.gipstech.mdk.spatial.Building4j
import com.gipstech.mdk.spatial.BuildingInfo
import com.gipstech.mdk.spatial.Coordinates
import com.gipstech.mdk.spatial.Region4j
import kotlinx.coroutines.runBlocking

/**
 * Java-facing facade for the [SpatialManager4j] class.
 *
 * This class provides static methods that wrap coroutine-based SDK functions
 * using 'runBlocking', allowing them to be invoked from Java code in a blocking way.
 */
class SpatialManager4j {
    companion object {
        @JvmStatic
        fun queryBuildingsNearby(longitude: Double, latitude: Double, radius: Double, includeFloors: Boolean): List<BuildingInfo> = runBlocking {
            SpatialManager.queryBuildingsNearby(longitude, latitude, radius, includeFloors)
        }

        @JvmStatic
        fun queryBuildingsByBounds(southWest: Coordinates, northEast: Coordinates, includeFloors: Boolean) = runBlocking {
            SpatialManager.queryBuildingsByBounds(southWest, northEast, includeFloors)
        }

        @JvmStatic
        fun queryBuildingsByBounds(swLongitude: Double, swLatitude: Double, neLongitude: Double, neLatitude: Double, includeFloors: Boolean) = runBlocking {
            SpatialManager.queryBuildingsByBounds(
                swLongitude,
                swLatitude,
                neLongitude,
                neLatitude,
                includeFloors
            )
        }

        @JvmStatic
        fun requestBuilding(buildingId: String, fallback: Boolean) = runBlocking {
            Building4j(SpatialManager.requestBuilding(buildingId, fallback))
        }

        @JvmStatic
        fun requestRegion(southWest: Coordinates, northEast: Coordinates, fallback: Boolean) = runBlocking {
            Region4j(SpatialManager.requestRegion(southWest, northEast, fallback))
        }

        @JvmStatic
        fun requestRegion(swLongitude: Double, swLatitude: Double, neLongitude: Double, neLatitude: Double, fallback: Boolean) = runBlocking {
            Region4j(SpatialManager.requestRegion(swLongitude, swLatitude, neLongitude, neLatitude, fallback))
        }

        @JvmStatic
        fun getLocationFromOS() = runBlocking {
            SpatialManager.getLocationFromOS()
        }
    }
}