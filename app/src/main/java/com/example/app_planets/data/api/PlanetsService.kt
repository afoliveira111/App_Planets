package com.example.app_planets.data.api

import retrofit2.http.GET

interface PlanetsService {
    @GET("planets")
    suspend fun getPlanets(): List<PlanetEntityAPI>
}