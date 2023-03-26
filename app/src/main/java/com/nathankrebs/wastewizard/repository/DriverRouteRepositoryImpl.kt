package com.nathankrebs.wastewizard.repository

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.nathankrebs.wastewizard.db.DriverLocalDataSource
import com.nathankrebs.wastewizard.db.model.DriverLocalItem
import com.nathankrebs.wastewizard.db.model.RouteLocalItem
import com.nathankrebs.wastewizard.model.DriverItem
import com.nathankrebs.wastewizard.model.RouteItem
import com.nathankrebs.wastewizard.network.DriverRemoteDataSource
import com.nathankrebs.wastewizard.network.model.DriverApiItem
import com.nathankrebs.wastewizard.network.model.RouteApiItem
import kotlin.random.Random

class DriverRouteRepositoryImpl(
    private val driverRemoteDataSource: DriverRemoteDataSource,
    private val driverLocalDataSource: DriverLocalDataSource,
) : DriverRouteRepository {

    override suspend fun getAllDrivers(): List<DriverItem> {
        val localData = driverLocalDataSource.getAllDrivers()
        if (localData.isNotEmpty()) return localData.map { it.toModel() }

        // we don't have data, so we need to request it and store it
        val response = driverRemoteDataSource.getDriverAndRoute()
        val drivers = response.drivers.map { it.toLocalModel() }
        val routes = response.routes.map { it.toLocalModel() }
        driverLocalDataSource.saveDrivers(drivers)
        driverLocalDataSource.saveRoutes(routes)

        return drivers.map { it.toModel() }
    }

    override suspend fun getRouteWithId(id: Int): RouteItem? {
        return driverLocalDataSource.getRouteWithId(id)?.toModel()
    }

    override suspend fun getAllCommercialRoutes(): List<RouteItem> {
        return driverLocalDataSource.getAllCommercialRoutes()
            .map { it.toModel() }
    }

    override suspend fun getAllIndustrialRoutes(): List<RouteItem> {
        return driverLocalDataSource.getAllIndustrialRoutes()
            .map { it.toModel() }
    }

    override suspend fun getAllResidentialRoutes(): List<RouteItem> {
        return driverLocalDataSource.getAllResidentialRoutes()
            .map { it.toModel() }
    }
}

/**
 * Converts an instance of [DriverApiItem] to [DriverLocalItem]
 */
private fun DriverApiItem.toLocalModel(): DriverLocalItem =
    DriverLocalItem(
        id = this.id,
        name = this.name,
    )

/**
 * Converts an instance of [RouteApiItem] to [RouteLocalItem]
 */
private fun RouteApiItem.toLocalModel(): RouteLocalItem =
    RouteLocalItem(
        id = this.id,
        type = this.type,
        name = this.name,
    )

/**
 * Converts an instance of [DriverLocalItem] to [DriverItem]
 */
private fun DriverLocalItem.toModel(): DriverItem =
    DriverItem(
        id = this.id,
        name = this.name,
        hexColor = getRandomColorHex()
    )

private fun getRandomColorHex(): String {
    val color = Color(
        red = Random.nextInt(256),
        green = Random.nextInt(256),
        blue = Random.nextInt(256),
    )
    return "#${Integer.toHexString(color.toArgb())}"
}

/**
 * Converts an instance of [RouteLocalItem] to [RouteItem]
 */
private fun RouteLocalItem.toModel(): RouteItem =
    RouteItem(
        id = this.id,
        type = this.type,
        name = this.name,
    )
