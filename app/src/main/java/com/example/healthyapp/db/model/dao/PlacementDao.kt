package com.example.healthyapp.db.model.dao

import androidx.room.*
import com.example.healthyapp.db.model.entity.Placement

@Dao
interface PlacementDao {

    @Insert
    fun addPlacement(placement: Placement): Int

    @Delete
    fun deletePlacement(placement: Placement): Int

    @Update
    fun updatePlacement(placement: Placement)

    @Query("SELECT * FROM placement WHERE id = :id ")
    fun getPlacementById(id: Long): Placement
}