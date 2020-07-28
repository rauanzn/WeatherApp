package com.example.domain.entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity
data class Sys(
    @PrimaryKey(autoGenerate = true)
    var sys_pr_id: Int,
    @SerializedName("country")
    @ColumnInfo(name = "country")
    var country: String,
    @SerializedName("id")
    var sys_id: Int?,
    @SerializedName("message")
    @ColumnInfo(name = "message")
    var message: Double,
    @SerializedName("sunrise")
    @ColumnInfo(name = "sunrise")
    var sunrise: Int,
    @SerializedName("sunset")
    @ColumnInfo(name = "sunset")
    var sunset: Int,
    @SerializedName("type")
    @ColumnInfo(name = "type")
    var type: Int
)