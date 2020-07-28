package com.example.weatherapp.implementations.data_sources

import androidx.lifecycle.LiveData
import com.example.domain.datasources.CacheWeatherDataSource
import com.example.domain.entity.WeatherResponse
import com.example.weatherapp.WeatherDao
import javax.inject.Inject

class CacheDataSourceImpl @Inject constructor(var weatherResponseDao:WeatherDao) :CacheWeatherDataSource{
    override suspend fun add(weatherResponse: WeatherResponse) {
        weatherResponseDao.insertAll(weatherResponse)
    }

    override fun getAll(): LiveData<List<WeatherResponse?>> =
        weatherResponseDao.getAllWeatherData()

    override suspend fun removeAll() {
        weatherResponseDao.deleteAll()
    }

    override fun getWeatherById(id: Int): LiveData<WeatherResponse> =
        weatherResponseDao.getWeatherDataById(id)


}