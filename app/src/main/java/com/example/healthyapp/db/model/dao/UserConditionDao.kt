package com.example.healthyapp.db.model.dao

import androidx.room.*
import com.example.healthyapp.db.model.entity.User
import com.example.healthyapp.db.model.entity.UserCondition

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