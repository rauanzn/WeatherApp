package com.example.weatherapp.usecases

import com.example.domain.entity.WeatherResponse
import com.example.domain.repositories.WeatherRepository

class AddWeatherUseCase (private val weatherRepository: WeatherRepository){
    suspend operator fun invoke(weatherResponse: WeatherResponse) = weatherRepository.addWeatherResponsesToDb(weatherResponse)
}