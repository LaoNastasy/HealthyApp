package com.example.healthyapp

import android.app.Application
import androidx.room.Room
import com.example.healthyapp.db.Database

class App : Application() {

    private val db = Room.databaseBuilder(
            applicationContext,
            Database::class.java, "database"
    ).build()
}