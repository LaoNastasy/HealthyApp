package com.example.healthyapp.db.model

import androidx.room.*

@Dao
interface UserConditionDao {

    @Insert
    fun addUserCondition(userCondition: UserCondition): Long

    @Update
    fun updateUserCondition(user: User): Int

    @Delete
    fun deleteUserCondition(user: User): Int

    @Query("SELECT * FROM USER_CONDITION WHERE ID = :id")
    fun getUserConditionById(id: Long): UserCondition

    @Query("SELECT * FROM USER_CONDITION WHERE ID_USER = :idUser")
    fun getUserConditionByUserId(idUser: Long): UserCondition
}