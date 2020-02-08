package com.example.healthyapp.features.auth

import com.example.healthyapp.repo.UserRepository
import com.example.healthyapp.base.BasePresenter
import com.example.healthyapp.base.BaseView
import javax.inject.Inject

interface AuthenticationView : BaseView {
    fun goToMainScreen()
    fun gotoRegistration()
}

class AuthenticationPresenter @Inject constructor(private val userRepository: UserRepository) :
    BasePresenter<AuthenticationView>() {


    fun login(login: String, password: String) {
        userRepository.getUserByLogin(
            login,
            {
                if (it?.password == password)
                    userRepository.signIn(login,
                        { view?.goToMainScreen() },
                        { view?.showError() })
                else view?.showError()
            },
            { view?.showError() }
        )


    }

    fun onRegistrationClick() {
        view?.gotoRegistration()
    }
}