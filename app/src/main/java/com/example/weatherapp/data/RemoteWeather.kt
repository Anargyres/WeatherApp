package com.example.weatherapp.data

import com.example.weatherapp.domain.WeatherData

class RemoteWeather(private val weatherService: WeatherService) {

    /**
     * /services/json/Paris
     */
    suspend fun getWeatherData(): WeatherData {
        val response = weatherService.getWeatherData()

        return when {
            response.isSuccessful -> response.body()?.toEntity() ?: WeatherData.ERROR
            else -> WeatherData.ERROR
        }
    }
}