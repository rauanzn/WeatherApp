package com.example.domain.entity


import androidx.room.*
import com.example.domain.entity.converters.DataConverter
import com.example.domain.entity.converters.DateConverter
import com.google.gson.annotations.SerializedName
import java.util.*

@Entity(tableName = "weather_response")
data class WeatherResponse(
    @PrimaryKey(autoGenerate = true)
    var pr_id: Int,
    @SerializedName("id")
    @ColumnInfo(name = "id")
    var id: Int,
    @SerializedName("base")
    @ColumnInfo(name = "base")
    var base: String,
    @SerializedName("clouds")
    @Embedded
    var clouds: Clouds,
    @TypeConverters(DataConverter::class)
    @ColumnInfo(name = "weather")
    @SerializedName("weather")
    var weather: List<Weather> = listOf(),
    @SerializedName("cod")
    @ColumnInfo(name = "cod")
    var cod: Int,
    @SerializedName("coord")
    @Embedded
    var coord: Coord,
    @SerializedName("dt")
    @ColumnInfo(name = "dt")
    var dt: Int,
    @SerializedName("main")
    @Embedded
    var main: Main,
    @SerializedName("name")
    @ColumnInfo(name = "name")
    var name: String,
    @SerializedName("sys")
    @Embedded
    var sys: Sys,
    @SerializedName("visibility")
    @ColumnInfo(name = "visibility")
    var visibility: Int,
    @SerializedName("wind")
    @Embedded
    var wind: Wind,
    @ColumnInfo(name = "current_date")
    var date:Date?
)