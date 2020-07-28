package com.example.data.repositories

import androidx.lifecycle.LiveData
import com.example.domain.datasources.CacheWeatherDataSource
import com.example.domain.datasources.NetworkWeatherDataSource
import com.example.domain.entity.WeatherResponse
import com.example.domain.repositories.WeatherRepository
import retrofit2.Response
import java.util.*
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    var cacheWeatherDataSource: CacheWeatherDataSource,
    var networkWeatherDataSource: NetworkWeatherDataSource
): WeatherRepository {
    override suspend fun getWeatherByCityName(cityName: String): Response<WeatherResponse> =
        networkWeatherDataSource.getWeatherDataByCityName(cityName)


    override fun getWeatherResponsesFromDb(): LiveData<List<WeatherResponse?>> =
        cacheWeatherDataSource.getAll()


    override suspend fun removeAllWeatherResponsesFromDb() =
        cacheWeatherDataSource.removeAll()

    override suspend fun addWeatherResponsesToDb(weatherResponse: WeatherResponse){
        weatherResponse.date = Calendar.getInstance().time
        cacheWeatherDataSource.add(weatherResponse)
    }

    override fun getWeatherResponseById(id: Int): LiveData<WeatherResponse> =
        cacheWeatherDataSource.getWeatherById(id)


}