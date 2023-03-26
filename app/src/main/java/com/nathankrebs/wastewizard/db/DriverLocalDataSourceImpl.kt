package com.nathankrebs.wastewizard.db

import com.nathankrebs.wastewizard.db.model.DriverLocalItem
import com.nathankrebs.wastewizard.db.model.RouteLocalItem

class DriverLocalDataSourceImpl(
    private val database: DriverRouteDatabase,
): DriverLocalDataSource {
    override suspend fun getAllDrivers(): List<DriverLocalItem> {
        return database.driverDao().getAllDrivers()
    }

    override suspend fun getRouteWithId(id: Int): RouteLocalItem? {
        return database.routeDao().getRouteById(id)
    }

    override suspend fun getAllCommercialRoutes(): List<RouteLocalItem> {
        return database.routeDao().getRoutesByType("C")
    }

    override suspend fun getAllIndustrialRoutes(): List<RouteLocalItem> {
        return database.routeDao().getRoutesByType("I")
    }

    override suspend fun getAllResidentialRoutes(): List<RouteLocalItem> {
        return database.routeDao().getRoutesByType("R")
    }
}