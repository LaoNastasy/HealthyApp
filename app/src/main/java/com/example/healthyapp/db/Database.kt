package com.example.healthyapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.healthyapp.db.model.dao.*
import com.example.healthyapp.db.model.entity.*

@Database(
    entities = [
        Placement::class,
        PlacementCondition::class,
        ReferenceIndicators::class,
        User::class,
        UserCondition::class,
        WorkplaceUser::class,
        Workplace::class
    ], version = 1
)
abstract class Database : RoomDatabase() {

    abstract fun getPlacementConditionDao(): PlacementConditionDao
    abstract fun getPlacementDao(): PlacementDao
    abstract fun getReferenceIndicatorsDao(): ReferenceIndicatorsDao
    abstract fun getUserDao(): UserDao
    abstract fun getUserConditionDao(): UserConditionDao
    abstract fun getWorkplaceUserDao(): WorkplaceUserDao
    abstract fun getWorkplaceDao():WorkplaceDao
}