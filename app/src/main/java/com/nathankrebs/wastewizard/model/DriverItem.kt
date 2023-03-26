package com.nathankrebs.wastewizard.model

import kotlinx.serialization.Serializable

/**
 * @property hexColor A hexadecimal representation of a color associated with the item
 */
@Serializable
data class DriverItem(
    val id: Int,
    val name: String,
    val hexColor: String,
)
