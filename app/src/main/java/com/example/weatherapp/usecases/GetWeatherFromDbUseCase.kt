package com.example.weatherapp.usecases

import androidx.lifecycle.LiveData
import com.example.domain.entity.WeatherResponse
import com.example.domain.repositories.WeatherRepository

class GetWeatherFromDbUseCase (private var weatherRepository: WeatherRepository){
    suspend operator fun invoke():LiveData<List<WeatherResponse?>> = weatherRepository.getWeatherResponsesFromDb()
}