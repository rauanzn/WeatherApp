package com.example.weatherapp.ui.base

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.annotation.CallSuper
import androidx.lifecycle.*
import com.example.domain.repositories.WeatherRepository
import com.example.weatherapp.MyApplication
import com.example.weatherapp.Resource
import javax.inject.Inject

abstract class MainViewModel(app: Application) : AndroidViewModel(app) {
    init {
        (app as MyApplication).appComponent?.doInjection(this)
    }
    @Inject
    lateinit var repository:WeatherRepository

    private val stateHolder = MutableLiveData(Unit)
    private var mIsAlive = false

    @SuppressLint("StaticFieldLeak")
    val context: Context = app.applicationContext

    val state = Transformations.switchMap(stateHolder){
        onCreateState()
    }

    abstract fun onCreateState(): LiveData<Resource<Any>>

    @CallSuper
    open fun resetState() {
        stateHolder.postValue(Unit)
    }


    companion object {

        inline fun <reified M : MainViewModel> get(fragment: androidx.fragment.app.Fragment): M {
            return ViewModelProvider(fragment).get(M::class.java)
        }


    }
}