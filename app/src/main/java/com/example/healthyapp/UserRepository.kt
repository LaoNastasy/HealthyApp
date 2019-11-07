package com.example.healthyapp

import com.example.healthyapp.db.model.entity.User

interface UserRepository {
    fun getUserByLogin(login: String): User?
    fun isUserSignedIn(): Boolean
}