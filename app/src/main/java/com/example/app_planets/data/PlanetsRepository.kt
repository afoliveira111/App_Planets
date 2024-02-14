package com.example.app_planets.data


import com.example.app_planets.data.api.PlanetsService
import com.example.app_planets.ui.main.PlanetData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class PlanetsRepository @Inject constructor(private val service: PlanetsService) {

    suspend fun getPlanetList(): List<PlanetData> {
        return withContext(Dispatchers.IO) {
            service.getPlanets().map {
                PlanetData(it.name, it.description)
            }
        }
    }
}