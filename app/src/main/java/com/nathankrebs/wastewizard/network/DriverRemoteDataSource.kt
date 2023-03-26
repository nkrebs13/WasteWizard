package com.nathankrebs.wastewizard.network

import com.nathankrebs.wastewizard.network.model.DriverAndRouteApiItem

interface DriverRemoteDataSource {
    suspend fun getDriverAndRoute(): DriverAndRouteApiItem
}