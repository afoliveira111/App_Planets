package com.example.app_planets.data


import com.example.app_planets.data.api.ApiResult
import com.example.app_planets.data.api.PlanetsService
import com.example.app_planets.data.database.PlanetDatabaseEntity
import com.example.app_planets.data.database.PlanetsDao
import com.example.app_planets.ui.main.PlanetData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class PlanetsRepository @Inject constructor(
    private val service: PlanetsService,
    private val dao : PlanetsDao

) {

    suspend fun getPlanetList(): ApiResult<List<PlanetData>> {
        return withContext(Dispatchers.IO) {
            try {
                val apiEntities = service.getPlanets()
                val planetsData =  apiEntities.map {
                    PlanetData(it.name, it.description, it.url)
                }
                val databaseEntities = apiEntities.map {
                    PlanetDatabaseEntity(it.id, it.name, it.description, it.url)
                }
                dao.insert(databaseEntities)
                ApiResult.Success(planetsData)
            } catch (exception : java.lang.Exception){
                ApiResult.Error(exception)
            }
        }
    }
}