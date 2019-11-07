package com.example.healthyapp

import com.example.healthyapp.db.model.entity.User

open class UserRepositoryImpl : UserRepository {


    override fun getUserByLogin(login: String): User? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isUserSignedIn(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}