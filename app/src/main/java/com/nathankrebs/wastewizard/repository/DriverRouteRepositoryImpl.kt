package com.nathankrebs.wastewizard.repository

import com.nathankrebs.wastewizard.db.DriverLocalDataSource
import com.nathankrebs.wastewizard.model.DriverItem
import com.nathankrebs.wastewizard.model.RouteItem
import com.nathankrebs.wastewizard.network.DriverRemoteDataSource

class DriverRouteRepositoryImpl(
    private val driverRemoteDataSource: DriverRemoteDataSource,
    private val driverLocalDataSource: DriverLocalDataSource,
) : DriverRouteRepository {
    override suspend fun getAllDrivers(): List<DriverItem> {
        TODO("Not yet implemented")
    }

    override suspend fun getRouteWithId(id: Int): RouteItem? {
        TODO("Not yet implemented")
    }

    override suspend fun getAllCommercialRoutes(): List<RouteItem> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllIndustrialRoutes(): List<RouteItem> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllResidentialRoutes(): List<RouteItem> {
        TODO("Not yet implemented")
    }
}