package com.example.weatherapp.domain

data class WeatherData(
    val city_info: CityInfo,
    val current_condition: CurrentCondition
) {
    companion object {
        val ERROR =
            WeatherData(CityInfo("", "", "", ""), CurrentCondition("", "", 0, 0, 0.0, 0, "", ""))
    }
}

data class CityInfo(
    val name: String,
    val country: String,
    val sunrise: String,
    val sunset: String
)

data class CurrentCondition(
    val date: String,
    val hour: String,
    val tmp: Int,
    val wnd_spd: Int,
    val pressure: Double,
    val humidity: Int,
    val condition: String,
    val condition_key: String
)