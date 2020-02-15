package com.example.healthyapp.db.model.dao

import androidx.room.*
import com.example.healthyapp.db.model.entity.Workplace

@Dao
interface WorkplaceDao {

    @Insert
    fun addWorkplace(workplace: Workplace): Long

    @Update
    fun updateWorkplace(workplace: Workplace): Int

    @Delete
    fun deleteWorkplace(workplace: Workplace): Int

    @Query("SELECT * FROM Workplace WHERE ID = :id")
    fun getById(id: Long): Workplace


}