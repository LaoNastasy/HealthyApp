package com.example.healthyapp.db.model

import androidx.room.*

@Dao
interface ReferenceIndicatorsDao {

    @Insert
    fun addReferenceIndicators(indicators: ReferenceIndicators): Int

    @Delete
    fun deleteReferenceIndicators(indicators: ReferenceIndicators): Int

    @Update
    fun updateReferenceIndicators(indicators: ReferenceIndicators)

    @Query("SELECT * FROM reference_indicators WHERE id = :id ")
    fun getReferenceIndicatorsById(id: Long): ReferenceIndicators
}