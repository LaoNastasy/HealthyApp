package com.example.healthyapp.db.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index(value = ["login"],
        unique = true)])
data class User(
        @PrimaryKey(autoGenerate = true)
        var id: Long,
        var login: String,
        var password: String,
        var role: String,
        @ColumnInfo(name = "first_name") var firstName: String,
        @ColumnInfo(name = "second_name") var secondName: String
)