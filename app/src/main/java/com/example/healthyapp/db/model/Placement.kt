package com.example.healthyapp.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Placement(
        @PrimaryKey(autoGenerate = true)
        var id: Long,
        var length: Double,
        var height: Double,
        var width: Double,
        @ColumnInfo(name = "windows_count") var windowsCount: Int?,
        @ColumnInfo(name = "window_height") var windowHeight: Double?,
        @ColumnInfo(name = "window_width") var windowWidth: Double?

)