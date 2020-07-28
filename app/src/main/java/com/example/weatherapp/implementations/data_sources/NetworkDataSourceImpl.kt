package com.example.weatherapp.implementations.data_sources

import com.example.data.apiservice.WeatherApiService
import com.example.domain.datasources.NetworkWeatherDataSource
import com.example.domain.entity.WeatherResponse
import com.example.weatherapp.utils.Config
import retrofit2.Response
import javax.inject.Inject

class NetworkDataSourceImpl @Inject constructor(var weatherApiService: WeatherApiService) :NetworkWeatherDataSource{
    override suspend fun getWeatherDataByCityName(cityName: String): Response<WeatherResponse> =
        weatherApiService.getWeatherResponse(cityName, Config.KEY)

}