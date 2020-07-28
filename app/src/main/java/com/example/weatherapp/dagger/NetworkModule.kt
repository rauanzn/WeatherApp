package com.example.weatherapp.dagger

import android.content.Context
import androidx.room.Room
import com.example.data.apiservice.WeatherApiService
import com.example.data.repositories.WeatherRepositoryImpl
import com.example.domain.datasources.CacheWeatherDataSource
import com.example.domain.datasources.NetworkWeatherDataSource
import com.example.domain.repositories.WeatherRepository
import com.example.weatherapp.WeatherDatabase
import com.example.weatherapp.implementations.data_sources.CacheDataSourceImpl
import com.example.weatherapp.implementations.data_sources.NetworkDataSourceImpl
import com.example.weatherapp.utils.Config
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [RoomModule::class])
class NetworkModule{
    @Provides
    @Singleton
    fun provideGson(): Gson {
        val builder =
            GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        return builder.setLenient().create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun getApiCallInterface(retrofit: Retrofit): WeatherApiService {
        return retrofit.create<WeatherApiService>(
            WeatherApiService::class.java)
    }

    @get:Provides
    @get:Singleton
    val requestHeader: OkHttpClient
        get() {
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            return httpClient.build()
        }

    @Provides
    @Singleton
    fun getRepository(cacheWeatherDataSource: CacheWeatherDataSource,networkWeatherDataSource: NetworkWeatherDataSource): WeatherRepository {
        return WeatherRepositoryImpl(cacheWeatherDataSource,networkWeatherDataSource)
    }

    @Provides
    @Singleton
    fun getNetworkDataSource(apiCallInterface: WeatherApiService):NetworkWeatherDataSource{
        return NetworkDataSourceImpl(apiCallInterface)
    }
}
