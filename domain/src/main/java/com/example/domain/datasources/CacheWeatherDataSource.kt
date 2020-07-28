package com.example.domain.datasources

import androidx.lifecycle.LiveData
import com.example.domain.entity.WeatherResponse

interface CacheWeatherDataSource {
    suspend fun add(weatherResponse: WeatherResponse)
    fun getAll():LiveData<List<WeatherResponse?>>
    suspend fun removeAll()
    fun getWeatherById(id:Int):LiveData<WeatherResponse>
}