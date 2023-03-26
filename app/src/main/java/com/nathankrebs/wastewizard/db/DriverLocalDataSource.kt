package com.nathankrebs.wastewizard.db

import com.nathankrebs.wastewizard.db.model.DriverLocalItem
import com.nathankrebs.wastewizard.db.model.RouteLocalItem

interface DriverLocalDataSource {
    /**
     * Returns a list of all [DriverLocalItem]
     */
    suspend fun getAllDrivers(): List<DriverLocalItem>

    /**
     * Returns the [RouteLocalItem] where [RouteLocalItem.id] is equal to [id] if there is one. If there is
     * not, null will be returned.
     */
    suspend fun getRouteWithId(id: Int): RouteLocalItem?

    /**
     * Returns a list of all commercial routes
     */
    suspend fun getAllCommercialRoutes(): List<RouteLocalItem>

    /**
     * Returns a list of all industrial routes
     */
    suspend fun getAllIndustrialRoutes(): List<RouteLocalItem>

    /**
     * Returns a list of all residential routes
     */
    suspend fun getAllResidentialRoutes(): List<RouteLocalItem>
}