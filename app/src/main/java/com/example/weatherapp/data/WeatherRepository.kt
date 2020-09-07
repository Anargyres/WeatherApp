package com.example.weatherapp.data

import com.example.weatherapp.domain.WeatherData

interface WeatherRepository {
    suspend fun getWeatherData(): WeatherData
}