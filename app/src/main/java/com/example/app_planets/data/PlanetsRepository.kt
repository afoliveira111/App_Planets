package com.example.app_planets.data


import com.example.app_planets.data.api.ApiResult
import com.example.app_planets.data.api.PlanetsService
import com.example.app_planets.ui.main.PlanetData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class PlanetsRepository @Inject constructor(private val service: PlanetsService) {

    suspend fun getPlanetList(): ApiResult<List<PlanetData>> {
        return withContext(Dispatchers.IO) {
            try {
                val planetsData =  service.getPlanets().map {
                    PlanetData(it.name, it.description, it.url)
                }
                ApiResult.Success(planetsData)
            } catch (exception : java.lang.Exception){
                ApiResult.Error(exception)
            }
        }
    }
}