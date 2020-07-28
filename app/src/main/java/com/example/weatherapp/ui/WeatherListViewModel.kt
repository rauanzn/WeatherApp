package com.example.weatherapp.ui

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.entity.WeatherResponse
import com.example.weatherapp.Resource
import com.example.weatherapp.ui.base.MainViewModel

class WeatherListViewModel(app:Application) : MainViewModel(app) {
    private val result = MutableLiveData<Resource<Any>>(Resource.loading())
    override fun onCreateState(): LiveData<Resource<Any>> = result
    fun getFromDb():LiveData<List<WeatherResponse?>> = repository.getWeatherResponsesFromDb()

}