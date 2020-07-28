package com.example.weatherapp.usecases

import com.example.domain.repositories.WeatherRepository

class GetWeatherUseCaseImpl(private val weatherRepository: WeatherRepository) {
    suspend operator fun invoke(cityName: String) = weatherRepository.getWeatherByCityName(cityName)
}