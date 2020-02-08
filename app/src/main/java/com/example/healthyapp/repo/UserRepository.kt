package com.example.healthyapp.repo

import com.example.healthyapp.db.model.entity.User

interface UserRepository {
    fun getUserByLogin(
        login: String,
        onSuccess: (user: User) -> Unit,
        onError: () -> Unit
    )

    fun isUserSignedIn(): Boolean

    fun signIn(
        login: String,
        onSuccess: () -> Unit,
        onError: () -> Unit
    )

    fun logout(
        onSuccess: () -> Unit,
        onError: () -> Unit
    )

    fun signUp(
        login: String, password: String,
        onSuccess: () -> Unit,
        onError: () -> Unit
    )
}