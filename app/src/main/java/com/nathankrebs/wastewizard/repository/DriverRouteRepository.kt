package com.nathankrebs.wastewizard.repository

import com.nathankrebs.wastewizard.model.DriverItem
import com.nathankrebs.wastewizard.model.RouteItem

interface DriverRouteRepository {
    /**
     * Returns a list of all [DriverItem]
     */
    suspend fun getAllDrivers(): List<DriverItem>

    /**
     * Returns the [RouteItem] where [RouteItem.id] is equal to [id] if there is one. If there is
     * not, null will be returned.
     */
    suspend fun getRouteWithId(id: Int): RouteItem?

    /**
     * Returns a list of all commercial routes
     */
    suspend fun getAllCommercialRoutes(): List<RouteItem>

    /**
     * Returns a list of all industrial routes
     */
    suspend fun getAllIndustrialRoutes(): List<RouteItem>

    /**
     * Returns a list of all residential routes
     */
    suspend fun getAllResidentialRoutes(): List<RouteItem>
}