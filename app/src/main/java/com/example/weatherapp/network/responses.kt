package com.example.weatherapp.network

import java.sql.Timestamp
import java.text.SimpleDateFormat
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
//    fun publishedTime(source: String): String
//    {
//        return if (publishedAt != null) {
//
//            val pattern = if (source == "bbc-news")
//                "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
//            else
//                "yyyy-MM-dd'T'HH:mm:ss'Z'"
//
//            val simpleDateFormat = SimpleDateFormat(pattern, Locale.ENGLISH)
//            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"))
//            val timestamp = Timestamp(simpleDateFormat.parse(publishedAt!!)!!.time)
//            timestamp.toString()
//        } else ""
//    }
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
}

data class Wind(
    var speed: Double? = null,
    var deg: Int? = null
)