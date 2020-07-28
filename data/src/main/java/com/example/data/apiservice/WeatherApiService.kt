package com.example.data.apiservice

import com.example.domain.entity.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService{
    @GET("data/2.5/weather")
    suspend fun getWeatherResponse(@Query("q") q:String,@Query("appid") appid:String):Response<WeatherResponse>
}
