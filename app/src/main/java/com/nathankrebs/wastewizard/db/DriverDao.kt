package com.nathankrebs.wastewizard.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nathankrebs.wastewizard.db.model.DriverLocalItem

@Dao
interface DriverDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDrivers(drivers: List<DriverLocalItem>)

    @Query("SELECT * FROM DriverLocalItem")
    suspend fun getAllDrivers(): List<DriverLocalItem>
}
