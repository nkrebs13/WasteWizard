package com.nathankrebs.wastewizard.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nathankrebs.wastewizard.db.model.DriverLocalItem
import com.nathankrebs.wastewizard.db.model.RouteLocalItem

@Database(entities = [DriverLocalItem::class, RouteLocalItem::class], version = 1)
abstract class DriverRouteDatabase: RoomDatabase() {
    abstract fun driverDao(): DriverDao
    abstract fun routeDao(): RouteDao

    companion object {
        @Volatile
        private var INSTANCE: DriverRouteDatabase? = null

        fun getDatabase(context: Context): DriverRouteDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DriverRouteDatabase::class.java,
                    "driver_route_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
