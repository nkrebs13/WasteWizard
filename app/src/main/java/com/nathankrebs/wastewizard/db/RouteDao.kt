package com.nathankrebs.wastewizard.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nathankrebs.wastewizard.db.model.RouteLocalItem

@Dao
interface RouteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRoutes(routes: List<RouteLocalItem>)

    @Query("SELECT * FROM RouteLocalItem WHERE id = :id")
    suspend fun getRouteById(id: Int): RouteLocalItem?

    @Query("SELECT * FROM RouteLocalItem WHERE type = :type")
    suspend fun getRoutesByType(type: String): List<RouteLocalItem>
}
