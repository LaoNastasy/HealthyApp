package com.example.healthyapp.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Placement(
        @PrimaryKey(autoGenerate = true)
        var id: Long = 0,
        var length: Double = 0.0,
        var height: Double = 0.0,
        var width: Double = 0.0,
        var windowsCount: Int? = 0,
        var windowHeight: Double? = 0.0,
        var windowWidth: Double? = 0.0

)