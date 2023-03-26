package com.nathankrebs.wastewizard.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DriverLocalItem(
    @PrimaryKey val id: Int,
    @ColumnInfo val name: String,
)
