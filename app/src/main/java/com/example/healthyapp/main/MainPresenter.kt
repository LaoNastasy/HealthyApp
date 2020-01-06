package com.example.healthyapp.main

import com.example.healthyapp.repo.UserRepository
import com.example.healthyapp.base.BasePresenter
import com.example.healthyapp.base.BaseView
import javax.inject.Inject

interface MainView : BaseView {
    fun goToBaseRoomEditFragment()
    fun goToAuthFragment()
}

class MainPresenter @Inject constructor(private val userRepository: UserRepository) : BasePresenter<MainView>() {

    fun checkAuth() {
        if (userRepository.isUserSignedIn()) view?.goToBaseRoomEditFragment()
        else view?.goToAuthFragment()
    }
}