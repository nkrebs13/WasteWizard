package com.nathankrebs.wastewizard.db

import androidx.room.Dao
import androidx.room.Query
import com.nathankrebs.wastewizard.db.model.RouteLocalItem

@Dao
interface RouteDao {
    @Query("SELECT * FROM RouteLocalItem WHERE id = :id")
    suspend fun getRouteById(id: Int): RouteLocalItem?

    @Query("SELECT * FROM RouteLocalItem WHERE type = :type")
    suspend fun getRoutesByType(type: String): List<RouteLocalItem>
}