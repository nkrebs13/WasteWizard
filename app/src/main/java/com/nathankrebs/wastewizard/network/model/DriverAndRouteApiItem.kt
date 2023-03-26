package com.nathankrebs.wastewizard.network.model

import kotlinx.serialization.Serializable

@Serializable
data class DriverAndRouteApiItem(
    val drivers: List<DriverApiItem>,
    val routes: List<RouteApiItem>,
)