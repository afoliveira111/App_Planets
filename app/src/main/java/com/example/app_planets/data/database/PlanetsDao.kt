package com.example.app_planets.data.database

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface PlanetsDao {

    @Insert
    fun insert(planets : List<PlanetDatabaseEntity>)
}