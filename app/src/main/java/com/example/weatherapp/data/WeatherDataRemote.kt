package com.example.weatherapp.data

import com.example.weatherapp.domain.CityInfo
import com.example.weatherapp.domain.CurrentCondition
import com.example.weatherapp.domain.WeatherData

data class WeatherDataRemote(
    val city_info: CityInfo,
    val current_condition: CurrentCondition
) {
    fun toEntity(): WeatherData {
        return WeatherData(
            city_info = city_info,
            current_condition = current_condition
        )
    }
}
