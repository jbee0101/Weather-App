package com.example.weatherapp.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.R
import com.example.weatherapp.databinding.WeatherDetailActivityBinding

class WeatherDetailActivity : AppBaseActivity() {
    val TAG = "WeatherDetailActivity"

    private val binding: WeatherDetailActivityBinding by ActivityBindingProperty(R.layout.weather_detail_activity)

    private lateinit var viewModel: WeatherDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(WeatherDetailViewModel::class.java)

        val city = intent.getStringExtra("city")
        binding.appBar.lblTitle.text = city!!.split(",")[0]

        viewModel.onGetWeatherOfCity(city)

        viewModel.newsResponse.observe(this) { response ->

            Log.e(TAG, "newsResponse: $response")

            binding.item = response
        }
    }
}