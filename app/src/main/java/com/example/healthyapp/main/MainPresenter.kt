package com.example.healthyapp.main

import com.example.healthyapp.UserRepository
import com.example.healthyapp.base.BasePresenter
import com.example.healthyapp.base.BaseView
import javax.inject.Inject

interface MainView : BaseView {
    fun goToBaseRoomEditScreen()
    fun goToAuthFragment()
}

class MainPresenter @Inject constructor(private val userRepository: UserRepository) : BasePresenter<MainView>() {

    fun checkAuth() {
        if (userRepository.isUserSignedIn()) view?.goToBaseRoomEditScreen()
        else view?.goToAuthFragment()
    }
}