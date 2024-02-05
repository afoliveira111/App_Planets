package com.example.app_planets.data

import com.example.app_planets.ui.main.PlanetData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class PlanetsRepository {

    suspend fun getPlanetList() : List<PlanetData>{
      return  withContext(Dispatchers.IO){
          delay(4000)
          listOf(
                PlanetData("Terra", "Descricao Terra"),
                PlanetData("Jupiter", "Descricao Jupiter"),
                PlanetData("Mercúrio", "Descricao Mercúrio")
            )
        }
    }
}