package com.example.weatherapp.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.network.ApiClient
import com.example.weatherapp.network.CurrentWeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList


class WeatherDetailViewModel: ViewModel()
{
    val newsResponse = MutableLiveData<CurrentWeatherResponse>()

    fun onGetWeatherOfCity(city: String)
    {
        val call = ApiClient.apiService().GetWeatherOfCity(q = city)

        call.enqueue(object : Callback<CurrentWeatherResponse>{
            override fun onFailure(call: Call<CurrentWeatherResponse>, t: Throwable) {
                Log.e("CitiesViewModel", "onFailure: ${t.localizedMessage}")
            }

            override fun onResponse(call: Call<CurrentWeatherResponse>, response: Response<CurrentWeatherResponse>)
            {
                Log.e("CitiesViewModel", "onResponse: ${response.body()}")
                if (response.isSuccessful)
                {
                    val body = response.body() as CurrentWeatherResponse
                    newsResponse.postValue(body)
                }
            }
        })
    }
}