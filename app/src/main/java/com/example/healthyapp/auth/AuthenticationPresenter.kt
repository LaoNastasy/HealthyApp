package com.example.healthyapp.auth

import com.example.healthyapp.UserRepository
import com.example.healthyapp.base.BasePresenter
import com.example.healthyapp.base.BaseView
import javax.inject.Inject

interface AuthenticationView : BaseView {
    fun goToBaseRoomEditScreen()
    fun showError()
}

class AuthenticationPresenter @Inject constructor(private val userRepository: UserRepository) :
    BasePresenter<AuthenticationView>() {


    fun login(login: String, password: String) {
        val user = userRepository.getUserByLogin(login)
        if (user?.password == password) view?.goToBaseRoomEditScreen()
        else view?.showError()
    }
}