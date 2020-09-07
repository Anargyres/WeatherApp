package com.example.weatherapp

import com.example.weatherapp.data.WeatherRepository
import com.example.weatherapp.domain.CityInfo
import com.example.weatherapp.domain.CurrentCondition
import com.example.weatherapp.domain.GetWeatherUseCase
import com.example.weatherapp.domain.WeatherData
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals

class GetWeatherUseCaseTest {

    private val weatherRepository : WeatherRepository = mockk()

    private val classUnderTest = GetWeatherUseCase(weatherRepository)

    @Test
    fun `Get Weather Data`() {
        runBlocking {
            //GIVEN
            val expectedResult = WeatherData(
                city_info = CityInfo("Paris", "France", "07:15", "20/21"),
                current_condition = CurrentCondition("07.09.2020", "11:00", 17, 7, 1021.7, 54, "Ensolleilé", "ensolleilé")
            )

            coEvery { weatherRepository.getWeatherData() } returns expectedResult

            //WHEN
            val result = classUnderTest.invoke()

            //THEN
            assertEquals(expectedResult, result)

        }
    }
}