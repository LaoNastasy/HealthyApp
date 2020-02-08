package com.example.healthyapp.db.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Workplace(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "user_id") val userId:Long,
    @ColumnInfo(name = "table_height") val tableHeight: Int,
    @ColumnInfo(name = "monitor_height") val monitorHeight: Int,
    @ColumnInfo(name = "keyboard_height") val keyboardHeight: Int,
    @ColumnInfo(name = "chair_height") val chairHeight: Int,
    @ColumnInfo(name = "stand_height") val standHeight: Int
)