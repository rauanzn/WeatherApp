package com.example.weatherapp.dagger

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.domain.datasources.CacheWeatherDataSource
import com.example.weatherapp.WeatherDatabase
import com.example.weatherapp.implementations.data_sources.CacheDataSourceImpl
import com.example.weatherapp.utils.Config
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class RoomModule(val context:Context) {

    @Provides
    @Singleton
    fun getRoomDatabase():WeatherDatabase =
        Room.databaseBuilder(context,
            WeatherDatabase::class.java,
            Config.DATABASE_NAME).build()

    @Provides
    @Singleton
    fun getCacheDataSource(weatherDatabase: WeatherDatabase) :CacheWeatherDataSource{
        return CacheDataSourceImpl(weatherDatabase.weatherDao())
    }
}