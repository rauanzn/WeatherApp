package com.example.domain.entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.domain.entity.converters.DataConverter
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity
data class Weather(
    @SerializedName("description")
    @ColumnInfo(name = "description")
    var description: String,
    @SerializedName("icon")
    @ColumnInfo(name = "icon")
    var icon: String,
    @SerializedName("id")
    @PrimaryKey
    var weather_id: Int,
    @SerializedName("main")
    @ColumnInfo(name = "main")
    var main: String
)