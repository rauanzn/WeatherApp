package com.example.domain.entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity
data class Clouds(
    @PrimaryKey(autoGenerate = true)
    val cloud_id:Int,
    @SerializedName("all")
    var all: Int
)