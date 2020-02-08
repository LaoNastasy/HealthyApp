package com.example.healthyapp.db.model.dao

import androidx.room.*
import com.example.healthyapp.db.model.entity.WorkplaceUser

@Dao
interface WorkplaceUserDao {

    @Insert
    fun addWorkplaceUser(user: WorkplaceUser): Long

    @Update
    fun updateWorkplaceUser(user: WorkplaceUser): Int

    @Delete
    fun deleteWorkplaceUser(user: WorkplaceUser): Int

    @Query("SELECT * FROM workplaceuser WHERE ID = :id")
    fun getById(id: Long): WorkplaceUser
}