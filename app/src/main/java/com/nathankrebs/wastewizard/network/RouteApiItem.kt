package com.nathankrebs.wastewizard.network

import kotlinx.serialization.Serializable

@Serializable
data class RouteApiItem(
    val id: Int,
    val type: String,
    val name: String,
)
