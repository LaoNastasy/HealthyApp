package com.example.healthyapp.repo.implementations

import com.example.healthyapp.R
import com.example.healthyapp.db.model.entity.User
import com.example.healthyapp.repo.UserRepository

class UserRepositoryFakeImpl : UserRepository {
    override fun getUserByLogin(login: String, onSuccess: (user: User) -> Unit, onError: (Int) -> Unit) {
        if (login == "login")
            onSuccess.invoke(
                User("0", "login", "password", "Alexandr", "Popov")
            )
        else onError.invoke(R.string.auth_no_login)
    }

    override fun isUserSignedIn() = true

    override fun signIn(login: String, onSuccess: () -> Unit, onError: () -> Unit) {
        onSuccess.invoke()
    }

    override fun logout(onSuccess: () -> Unit, onError: () -> Unit) {
        onSuccess.invoke()
    }

    override fun signUp(login: String, password: String, onSuccess: () -> Unit, onError: () -> Unit) {
        onSuccess.invoke()
    }
}