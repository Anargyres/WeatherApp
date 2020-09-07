package com.example.weatherapp.injection

import com.example.weatherapp.data.RemoteWeather
import com.example.weatherapp.data.WeatherRepository
import com.example.weatherapp.data.WeatherRepositoryImpl
import com.example.weatherapp.data.WeatherService
import com.example.weatherapp.domain.GetWeatherUseCase
import com.example.weatherapp.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

val appModule = module {

    single<WeatherRepository> { WeatherRepositoryImpl(get()) }

    single { RemoteWeather(get()) }

    single<WeatherService> { createWebService("https://prevision-meteo.ch") }
}

val presentationModule = module {

    viewModel { MainViewModel(get()) }
}

val domainModule = module {

    single { GetWeatherUseCase(get()) }
}

inline fun <reified T> createWebService(url: String): T {
    return Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create()
}