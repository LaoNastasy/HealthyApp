package com.example.healthyapp.features.main_screen

import com.example.healthyapp.base.BasePresenter
import com.example.healthyapp.base.BaseView
import com.example.healthyapp.repo.UserRepository
import javax.inject.Inject


interface MainScreenView : BaseView {

    fun goToPersonScreen()
    fun goToStatisticScreen()
    fun goToNewRoomScreen()
    fun goToInfoScreen()
    fun logOut()
}

class MainScreenPresenter @Inject constructor(
    private val userRepository: UserRepository
) : BasePresenter<MainScreenView>() {

    fun onPersonClick() {
        view?.goToPersonScreen()
    }

    fun onStatisticClick() = view?.goToStatisticScreen()

    fun onNewRoomClick() = view?.goToNewRoomScreen()

    fun onInfoClick() = view?.goToInfoScreen()

    fun logOut() {
        userRepository.logout(
            onSuccess = {view?.logOut()},
            onError = {view?.showError()}
        )
    }
}