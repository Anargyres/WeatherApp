package com.example.weatherapp

import android.app.Application
import com.example.weatherapp.injection.appModule
import com.example.weatherapp.injection.domainModule
import com.example.weatherapp.injection.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WeatherApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@WeatherApplication)
            modules(
                listOf(
                    appModule,
                    presentationModule,
                    domainModule
                )
            )
        }
    }
}