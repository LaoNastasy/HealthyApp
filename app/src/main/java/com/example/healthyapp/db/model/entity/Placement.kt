package com.example.healthyapp.db.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Placement(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    val number: Int,
    var length: Int,
    var height: Int,
    var width: Int
)