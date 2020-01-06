package com.example.healthyapp.repo

import com.example.healthyapp.db.Database
import com.example.healthyapp.db.model.entity.User
import javax.inject.Inject


open class UserRepositoryImpl @Inject constructor(val database: Database) :
    UserRepository {


    override fun getUserByLogin(login: String): User? {
        return database.getUserDao().getUserByLogin(login)
    }

    override fun isUserSignedIn(): Boolean {
        return false
    }
}