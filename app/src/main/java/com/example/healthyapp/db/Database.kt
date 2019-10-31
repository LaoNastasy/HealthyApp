package com.example.healthyapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.healthyapp.db.model.*

@Database(entities = [
    Placement::class,
    PlacementCondition::class,
    ReferenceIndicators::class,
    User::class,
    UserCondition::class
], version = 1)
abstract class Database : RoomDatabase() {

    abstract fun getPlacementConditionDao(): PlacementConditionDao
    abstract fun getPlacementDao(): PlacementDao
    abstract fun getReferenceIndicatorsDao(): ReferenceIndicatorsDao
    abstract fun getUserDao(): UserDao
    abstract fun getUserConditionDao(): UserConditionDao
}