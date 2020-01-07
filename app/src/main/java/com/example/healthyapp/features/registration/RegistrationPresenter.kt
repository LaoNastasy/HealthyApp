package com.example.healthyapp.features.registration

import com.example.healthyapp.base.BasePresenter
import com.example.healthyapp.base.BaseView
import com.example.healthyapp.repo.UserRepository
import javax.inject.Inject

interface RegistrationView : BaseView {
    fun goToMainFragment()
}

class RegistrationPresenter @Inject constructor(userRepo: UserRepository) :
    BasePresenter<RegistrationView>() {

    fun registrate(login: String, password: String) {

    }
}