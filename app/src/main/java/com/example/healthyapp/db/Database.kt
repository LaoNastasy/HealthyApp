package com.example.healthyapp.db

import androidx.room.RoomDatabase
import com.example.healthyapp.db.model.PlacementConditionDao
import com.example.healthyapp.db.model.PlacementDao

abstract class Database : RoomDatabase() {

    abstract fun getPlacementConditionDao(): PlacementConditionDao
    abstract fun getPlacementDao(): PlacementDao
}