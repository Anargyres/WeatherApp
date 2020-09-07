package com.example.weatherapp.data

import retrofit2.Response
import retrofit2.http.GET

interface WeatherService {

    @GET("/services/json/Paris")
    suspend fun getWeatherData(): Response<WeatherDataRemote>
}