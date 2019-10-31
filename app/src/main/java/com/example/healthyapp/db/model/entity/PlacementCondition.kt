package com.example.healthyapp.db.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "placement_condition")
data class PlacementCondition(
        @PrimaryKey(autoGenerate = true)
        var id: Long = 0,
        private var humidity: Int = 0,
        private var temperature: Int = 0,
        private var illumination: Int = 0
)
