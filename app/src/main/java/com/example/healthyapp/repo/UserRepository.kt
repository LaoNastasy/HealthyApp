package com.example.healthyapp.repo

import com.example.healthyapp.db.model.entity.User

interface UserRepository {

    /**
     * получение данных пользователя по логину, если такой существует
     * @param login - логин пользователя
     */
    fun getUserByLogin(
        login: String,
        onSuccess: (user: User) -> Unit,
        onError: () -> Unit
    )

    /**
     * проверка, авторизован ли пользователь
     * @return Boolean
     */
    fun isUserSignedIn(): Boolean

    /**
     * авторизация пользователя в приложении
     * @param login - логин пользователя
     */
    fun signIn(
        login: String,
        onSuccess: () -> Unit,
        onError: () -> Unit
    )

    /**
     * сброс авторизации
     */
    fun logout(
        onSuccess: () -> Unit,
        onError: () -> Unit
    )

    /**
     * регистрация пользователя в системе
     * @param login
     * @param password
     */
    fun signUp(
        login: String,
        password: String,
        onSuccess: () -> Unit,
        onError: () -> Unit
    )
}