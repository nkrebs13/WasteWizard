package com.nathankrebs.wastewizard.db

import androidx.room.Dao
import androidx.room.Query
import com.nathankrebs.wastewizard.db.model.DriverLocalItem

@Dao
interface DriverDao {
    @Query("SELECT * FROM DriverLocalItem")
    suspend fun getAllDrivers(): List<DriverLocalItem>
}