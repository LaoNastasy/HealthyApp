package com.example.healthyapp.features.auth

import com.example.healthyapp.R
import com.example.healthyapp.repo.UserRepository
import com.example.healthyapp.base.BasePresenter
import com.example.healthyapp.base.BaseView
import javax.inject.Inject

interface AuthenticationView : BaseView {
    fun goToMainScreen()
    fun showLoading(show: Boolean)
}

class AuthenticationPresenter @Inject constructor(private val userRepository: UserRepository) :
    BasePresenter<AuthenticationView>() {


    fun login(login: String, password: String) {
        view?.showLoading(true)
        userRepository.getUserByLogin(
            login = login,
            onSuccess = {
                if (it.password == password)
                    signIn(login)
                else
                    view?.apply {
                        showLoading(false)
                        showError(R.string.wrong_password)
                    }
            },
            onError = {
                view?.apply {
                    showLoading(false)
                    showError(it)
                }
            }
        )
    }

    private fun signIn(login: String){
        userRepository.signIn(
            login = login,
            onSuccess = { view?.goToMainScreen() },
            onError = {
                view?.apply {
                    showLoading(false)
                    showError()
                }
            })
    }


}