package com.nathankrebs.wastewizard.network.model

import kotlinx.serialization.Serializable

@Serializable
data class RouteApiItem(
    val id: Int,
    val type: String,
    val name: String,
)
