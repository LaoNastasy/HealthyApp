package com.example.healthyapp.repo

import com.example.healthyapp.db.model.entity.User

interface UserRepository {
    fun getUserByLogin(login: String): User?
    fun isUserSignedIn(): Boolean
}