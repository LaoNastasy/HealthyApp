package com.example.healthyapp

import com.example.healthyapp.db.Database
import com.example.healthyapp.db.model.entity.User
import javax.inject.Inject


open class UserRepositoryImpl @Inject constructor(val database:Database): UserRepository {


    override fun getUserByLogin(login: String): User? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isUserSignedIn(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}