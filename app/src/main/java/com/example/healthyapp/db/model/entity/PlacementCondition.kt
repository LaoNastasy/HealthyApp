package com.example.healthyapp.db.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "placement_condition")
data class PlacementCondition(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var humidity: Int = 0,
    var temperature: Int = 0,
    var illumination: Int = 0
)
