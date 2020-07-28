package com.example.weatherapp.dagger

import com.example.weatherapp.ui.base.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class,RoomModule::class])
@Singleton
interface AppComponent {
    fun doInjection(mainViewModel: MainViewModel)
}