package com.example.domain.repositories

import androidx.lifecycle.LiveData
import com.example.domain.entity.WeatherResponse
import retrofit2.Response

interface WeatherRepository{
    suspend fun getWeatherByCityName(cityName:String): Response<WeatherResponse>
    fun getWeatherResponsesFromDb(): LiveData<List<WeatherResponse?>>
    suspend fun removeAllWeatherResponsesFromDb()
    suspend fun addWeatherResponsesToDb(weatherResponse: WeatherResponse)
    fun getWeatherResponseById(id:Int): LiveData<WeatherResponse>
}