package com.nathankrebs.wastewizard.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RouteLocalItem(
    @PrimaryKey val id: Int,
    @ColumnInfo val type: String,
    @ColumnInfo val name: String,
)
