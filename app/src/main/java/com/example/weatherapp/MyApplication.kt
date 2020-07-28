package com.example.weatherapp

import android.app.Application
import android.content.Context
import com.example.weatherapp.dagger.AppComponent
import com.example.weatherapp.dagger.DaggerAppComponent
import com.example.weatherapp.dagger.NetworkModule
import com.example.weatherapp.dagger.RoomModule

@Suppress("DEPRECATION")
class MyApplication : Application() {
    var appComponent: AppComponent? = null
    var context: Context? = null

    override fun onCreate() {
        super.onCreate()
        context = this
        val networkModule = NetworkModule()
        val roomModule = RoomModule(this)
        appComponent = DaggerAppComponent.builder().roomModule(roomModule).networkModule(networkModule).build()
    }
}
