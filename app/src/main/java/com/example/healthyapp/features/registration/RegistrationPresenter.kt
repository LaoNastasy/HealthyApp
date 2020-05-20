package com.example.healthyapp.features.registration

import com.example.healthyapp.R
import com.example.healthyapp.base.BasePresenter
import com.example.healthyapp.base.BaseView
import com.example.healthyapp.repo.UserRepository
import javax.inject.Inject

interface RegistrationView : BaseView {
    fun goToMainScreen()
    fun showLoading(show: Boolean)
}

class RegistrationPresenter @Inject constructor(private val userRepo: UserRepository) :
    BasePresenter<RegistrationView>() {

    fun register(login: String, password: String, anotherPassword: String) {
        if (password != anotherPassword) {
            view?.showError(R.string.password_error)
            return
        }

        view?.showLoading(true)
        userRepo.signUp(
            login,
            password,
            {
                userRepo.signIn(
                    login,
                    { view?.goToMainScreen() },
                    {
                        view?.apply {
                            showLoading(false)
                            showError()
                        }
                    })
            },
            {
                view?.apply {
                    showLoading(false)
                    showError()
                }
            }
        )
    }
}