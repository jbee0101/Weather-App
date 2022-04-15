package com.example.weatherapp.network

import com.example.weatherapp.utils.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService
{
//    data/2.5/weather?lat={lat}&lon={lon}&appid={API key}
//    38.7345603,-9.1272459

    @GET("data/2.5/weather")
    fun GetCurrentWeather(@Query("lat") lat: Double = 38.7345603,
                        @Query("lon") lon: Double = -9.1272459,
                        @Query("appid") appid: String = Constants.API_ID): Call<CurrentWeatherResponse>

    @GET("data/2.5/weather")
    fun GetWeatherOfCity(@Query("q") q: String = "London,uk",
                          @Query("appid") appid: String = Constants.API_ID): Call<CurrentWeatherResponse>
}