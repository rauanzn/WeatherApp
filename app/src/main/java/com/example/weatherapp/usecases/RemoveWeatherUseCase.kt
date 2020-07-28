package com.example.weatherapp.usecases

import com.example.domain.repositories.WeatherRepository

class RemoveWeatherUseCase(private var weatherRepository: WeatherRepository) {
    suspend operator fun invoke() = weatherRepository.removeAllWeatherResponsesFromDb()
}