package com.example.domain.entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity
data class Wind(
    @PrimaryKey(autoGenerate = true)
    val wind_id:Int?,
    @SerializedName("deg")
    @ColumnInfo(name = "deg")
    var deg: Int,
    @SerializedName("speed")
    @ColumnInfo(name = "speed")
    var speed: Double
)