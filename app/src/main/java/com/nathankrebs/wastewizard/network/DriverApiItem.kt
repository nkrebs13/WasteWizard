package com.nathankrebs.wastewizard.network

import kotlinx.serialization.Serializable

@Serializable
data class DriverApiItem(
    val id: Int,
    val name: String,
)
