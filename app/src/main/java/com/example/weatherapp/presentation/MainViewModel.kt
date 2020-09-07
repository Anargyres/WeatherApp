package com.example.weatherapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.domain.GetWeatherUseCase
import com.example.weatherapp.domain.WeatherData
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainViewModel(
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {

    private val _liveDataWeather: MutableLiveData<WeatherData> = MutableLiveData()
    val liveDataWeather: LiveData<WeatherData> get() = _liveDataWeather

    init {
        viewModelScope.launch {
            _liveDataWeather.value = getWeatherUseCase.invoke()
        }
    }
}