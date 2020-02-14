package com.example.healthyapp.db.model.dao

import androidx.room.*
import com.example.healthyapp.db.model.entity.User

@Dao
interface UserDao {

    @Insert
    fun addUser(user: User): Long

    @Update
    fun updateUser(user: User): Int

    @Delete
    fun deleteUser(user: User): Int

    @Query("SELECT * FROM user WHERE ID = :id")
    fun getUserById(id: Long): User?

    @Query("SELECT * FROM user WHERE LOGIN = :login")
    fun getUserByLogin(login: String): User?
}