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
            login,
            {
                if (it.password == password)
                    userRepository.signIn(login,
                        { view?.goToMainScreen() },
                        {
                            view?.apply {
                                showLoading(false)
                                showError()
                            }
                        })
                else
                    view?.apply {
                        showLoading(false)
                        showError(R.string.wrong_password)
                    }
            },
            {
                view?.apply {
                    showLoading(false)
                    showError(it)
                }
            }
        )
    }

}