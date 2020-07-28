package com.example.weatherapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.domain.entity.WeatherResponse

@Dao
interface WeatherDao {
    @Query("SELECT * FROM weather_response")
    fun getAllWeatherData():LiveData<List<WeatherResponse?>>

    @Query("DELETE FROM weather_response")
    suspend fun deleteAll()

    @Insert
    suspend fun insertAll(weatherResponse: WeatherResponse)

    @Query("SELECT * FROM weather_response WHERE pr_id=:id ")
    fun getWeatherDataById(id: Int): LiveData<WeatherResponse>
}