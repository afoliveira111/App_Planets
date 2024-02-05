package com.example.app_planets.data


import com.example.app_planets.data.api.PlanetsClient
import com.example.app_planets.ui.main.PlanetData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class PlanetsRepository {

    private val service = PlanetsClient.getService()

    suspend fun getPlanetList(): List<PlanetData> {
        return withContext(Dispatchers.IO) {
            service.getPlanets().map {
                PlanetData(it.name, it.description)
            }
        }
    }
}