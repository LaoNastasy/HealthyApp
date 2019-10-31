package com.example.healthyapp.db.model

import androidx.room.*

@Dao
interface PlacementConditionDao {

    @Insert
    fun addPlacementCondition(placementCondition: PlacementCondition): Int

    @Delete
    fun deletePlacementCondition(placementCondition: PlacementCondition): Int

    @Update
    fun updatePlacementCondition(placementCondition: PlacementCondition)

    @Query("SELECT * FROM placement_condition WHERE id = :id ")
    fun getPlacementConditionById(id: Long): PlacementCondition
}