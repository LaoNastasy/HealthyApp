package com.example.healthyapp.db.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WorkplaceUser(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name = "name_user") val userName: String,
    @ColumnInfo(name = "height_user") val userHeight: Int,
    @ColumnInfo(name = "legs_height_user") val userLegsHeight: Int,
    @ColumnInfo(name = "back_height") val backHeight:Int
)