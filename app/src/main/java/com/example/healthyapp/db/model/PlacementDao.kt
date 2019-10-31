package com.example.healthyapp.db.model

import androidx.room.*

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