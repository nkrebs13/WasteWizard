package com.nathankrebs.wastewizard.network.model

import kotlinx.serialization.Serializable

@Serializable
data class DriverApiItem(
    val id: Int,
    val name: String,
)
