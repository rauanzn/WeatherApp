package com.example.weatherapp.ui

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.entity.WeatherResponse
import com.example.weatherapp.Resource
import com.example.weatherapp.Status
import com.example.weatherapp.ui.base.MainViewModel

class WeatherDetailViewModel(app:Application) : MainViewModel(app) {
    private val result = MutableLiveData<Resource<Any>>()
    override fun onCreateState(): LiveData<Resource<Any>> = result
    fun getWeatherById(id:Int):LiveData<WeatherResponse> {
        result.value = Resource.loading()
        result.postValue(Resource(Status.SUCCESS,null))
        return repository.getWeatherResponseById(id)
    }
}