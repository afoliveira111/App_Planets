package com.example.app_planets.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PlanetDatabaseEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun planetsDao(): PlanetsDao
}
