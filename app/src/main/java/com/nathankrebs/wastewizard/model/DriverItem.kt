package com.nathankrebs.wastewizard.model

import kotlinx.serialization.Serializable

@Serializable
data class DriverItem(
    val id: Int,
    val name: String,
)
