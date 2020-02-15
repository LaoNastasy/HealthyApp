package com.example.healthyapp.db.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_condition")
data class UserCondition(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    @ColumnInfo(name = "id_user") var idUser: Long,
    @ColumnInfo(name = "eye_discomfort") var eyeDiscomfort: String,
    @ColumnInfo(name = "legs_discomfort") var legsDiscomfort: Boolean,
    @ColumnInfo(name = "spinal_discomfort") var spinalDiscomfort: Boolean
)

