package com.example.healthyapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.healthyapp.db.model.dao.*
import com.example.healthyapp.db.model.entity.*

@Database(
    entities = [
        Placement::class,
        User::class,
        WorkplaceUser::class,
        Workplace::class
    ], version = 1
)
abstract class Database : RoomDatabase() {

    abstract fun getPlacementDao(): PlacementDao
    abstract fun getUserDao(): UserDao
    abstract fun getWorkplaceUserDao(): WorkplaceUserDao
    abstract fun getWorkplaceDao():WorkplaceDao
}