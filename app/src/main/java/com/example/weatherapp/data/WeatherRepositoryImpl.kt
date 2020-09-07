package com.example.weatherapp.data

import com.example.weatherapp.domain.WeatherData

class WeatherRepositoryImpl(
    private val remoteWeather: RemoteWeather
) : WeatherRepository {

    override suspend fun getWeatherData(): WeatherData {
        return remoteWeather.getWeatherData()
    }
}