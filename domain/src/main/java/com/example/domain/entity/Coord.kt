package com.example.domain.entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity
data class Coord(
    @PrimaryKey(autoGenerate = true)
    val coord_id:Int?,
    @SerializedName("lat")
    @ColumnInfo(name = "lat")
    var lat: Double,
    @SerializedName("lon")
    @ColumnInfo(name = "lon")
    var lon: Double
)