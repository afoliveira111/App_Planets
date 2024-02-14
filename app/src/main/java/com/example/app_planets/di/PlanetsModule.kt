package com.example.app_planets.di

import com.example.app_planets.data.PlanetsRepository
import com.example.app_planets.data.api.PlanetsService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object PlanetsModule {

    @Provides
    fun providePlanetService(): PlanetsService {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(
                Json.asConverterFactory(MediaType.parse("application/json")!!)
            )
            .baseUrl("https://us-central1-android-course-api.cloudfunctions.net/")
            .build()
        return retrofit.create(PlanetsService::class.java)
    }

    @Provides
    fun provideRepository(service: PlanetsService) : PlanetsRepository {
        return PlanetsRepository(service)
    }
}

