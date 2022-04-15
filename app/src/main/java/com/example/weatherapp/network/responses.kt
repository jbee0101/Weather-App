package com.example.weatherapp.network

import android.util.Log
import com.example.weatherapp.R
import java.util.*

data class City(
    val name: String? = null
)

data class CurrentWeatherResponse(
    var coord: Coordinates? = null,
    val weather: ArrayList<Weather>? = null,
    val base: String? = null,
    val main: MainDetails? = null,
    val visibility: Int? = null,
    val wind: Wind? = null,
    val timezone: Int? = null,
    val name: String? = null
)

data class Weather(
    var id: Int? = null,
    var main: String? = null,
    var description: String? = null,
    var icon: String? = null
)
{
    fun weatherIcon(): Int
    {
        Log.e("Response", "weatherIcon: $main")

        return when(main) {
            "Clouds" -> R.drawable.ic_cloud
            "Clear" -> R.drawable.ic_sunny
            "Rain" -> R.drawable.ic_rain
            else -> R.drawable.ic_cloud
        }
    }
}

data class Coordinates(
    var lon: Double? = null,
    var lat: Double? = null
)

data class MainDetails(
    var temp: Double? = null,
    var feels_like: Double? = null,
    var temp_min: Double? = null,
    var temp_max: Double? = null,
    var pressure: Int? = null,
    var humidity: Int? = null
)
{
    fun tempInCelsius():String
    {
        return String.format("%.2f", (temp!! - 273.15))
    }

    fun minTempInCelsius():String
    {
        return String.format("%.2f", (temp_min!! - 273.15))
    }

    fun maxTempInCelsius():String
    {
        return String.format("%.2f", (temp_max!! - 273.15))
    }
}

data class Wind(
    var speed: Double? = null,
    var deg: Int? = null
)