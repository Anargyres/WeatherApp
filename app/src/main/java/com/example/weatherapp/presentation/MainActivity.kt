package com.example.weatherapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.weatherapp.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        initObserver()
    }

    private fun initObserver() {
        mainViewModel.liveDataWeather.observe(this, Observer {
            it?.let {
                city_name.text = it.city_info.name
                country_name.text = it.city_info.country
                sunrise_hour.text = it.city_info.sunrise
                sunset_hour.text = it.city_info.sunset

                current_date.text = it.current_condition.date
                current_condition.text = it.current_condition.condition
                current_humidity.text = it.current_condition.humidity.toString() + "%"
                current_pression.text = it.current_condition.pressure.toString() + "hPa"
                current_tmp.text = it.current_condition.tmp.toString() + "°C"
                current_wnd.text = it.current_condition.wnd_spd.toString() + "noeuds"
            }
        })
    }
}