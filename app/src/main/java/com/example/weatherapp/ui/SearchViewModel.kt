package com.example.weatherapp.ui

import android.app.Application
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

class SearchViewModel(app:Application) : MainViewModel(app) {
    private val result = MutableLiveData<Resource<Any>>()
    override fun onCreateState(): LiveData<Resource<Any>> = result
    fun searchWeatherByCity(cityName:String?){
        if (cityName.isNullOrEmpty()) result.value = Resource.error("your query is not correct")
        else {
            viewModelScope.launch(Dispatchers.IO) {
                result.postValue(Resource.loading())
                repository.getWeatherByCityName(cityName).let {res->
                    if (res.isSuccessful) {
                        saveLocal(res.body()!!)
                        result.postValue(Resource(Status.SUCCESS, this))
                    } else if (res.code() == 404) {
                        result.postValue(Resource.error("There is no city like this"))
                    } else {
                        result.postValue(Resource.error("Oops something went wrong"))
                    }
                }

            }
        }
    }
    fun saveLocal(weatherResponse: WeatherResponse){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addWeatherResponsesToDb(weatherResponse)
        }
    }
}