package com.example.domain.entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity
data class Main(
    @PrimaryKey(autoGenerate = true)
    val main_id:Int?,
    @SerializedName("humidity")
    @ColumnInfo(name = "humidity")
    var humidity: Int,
    @SerializedName("pressure")
    @ColumnInfo(name = "pressure")
    var pressure: Int,
    @SerializedName("temp")
    @ColumnInfo(name = "temp")
    var temp: Double,
    @SerializedName("temp_max")
    @ColumnInfo(name = "temp_max")
    var tempMax: Double,
    @SerializedName("temp_min")
    @ColumnInfo(name = "temp_min")
    var tempMin: Double
)