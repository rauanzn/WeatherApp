package com.example.domain.datasources

import androidx.lifecycle.LiveData
import com.example.domain.entity.WeatherResponse
import retrofit2.Response

interface NetworkWeatherDataSource {
    suspend fun getWeatherDataByCityName(cityName:String): Response<WeatherResponse>
}