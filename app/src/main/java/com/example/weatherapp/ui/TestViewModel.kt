package com.example.weatherapp.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.WeatherResponse
import com.example.weatherapp.Resource
import com.example.weatherapp.Status
import com.example.weatherapp.ui.base.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TestViewModel(app:Application) : MainViewModel(app) {
    private val resource = MutableLiveData<Resource<Any>>(Resource.loading())

    override fun onCreateState(): LiveData<Resource<Any>> = resource
    init {
        viewModelScope.launch {
            repository.getWeatherResponsesFromDb().observeForever {
                Log.i("TestViewModel", "hello " + it.toString())
            }
        }
        viewModelScope.launch(Dispatchers.IO) {

            val data = repository.getWeatherByCityName("Almaty").body()
            resource.postValue(Resource(Status.SUCCESS,data))
            if (!((repository.getWeatherResponsesFromDb().value?: emptyList()).contains(data))) repository.addWeatherResponsesToDb(data!!)
        }
    }
}