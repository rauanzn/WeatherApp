package com.example.weatherapp

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.domain.entity.*
import com.example.domain.entity.converters.DataConverter
import com.example.domain.entity.converters.DateConverter

@Database(entities = [WeatherResponse::class,Weather::class,Clouds::class,Coord::class, Main::class,Sys::class,Wind::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class, DataConverter::class)
abstract class WeatherDatabase : RoomDatabase() {

    abstract fun weatherDao(): WeatherDao

}