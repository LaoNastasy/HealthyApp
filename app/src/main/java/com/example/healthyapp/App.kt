package com.example.healthyapp

import android.app.Application
import androidx.room.Room
import com.example.healthyapp.db.Database

class App : Application() {

    private var database: Database? = null

    override fun onCreate() {
        super.onCreate()
        database = createDatabase()
    }

    private fun createDatabase(): Database = Room.databaseBuilder(
            applicationContext,
            Database::class.java, "database"
    ).build()
}