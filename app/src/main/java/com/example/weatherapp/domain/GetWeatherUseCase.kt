package com.example.weatherapp.domain

import com.example.weatherapp.data.WeatherRepository

class GetWeatherUseCase(
    private val weatherRepository: WeatherRepository
) {
    suspend fun invoke(): WeatherData {
        return weatherRepository.getWeatherData()
    }
}