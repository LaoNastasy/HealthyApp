package com.example.healthyapp.features.main_screen

import com.example.healthyapp.base.BasePresenter
import com.example.healthyapp.base.BaseView


interface MainScreenView:BaseView{

    fun goToPersonScreen()
    fun goToStatisticScreen()
    fun goToNewRoomScreen()
    fun goToKlimatScreen()

}

class MainScreenPresenter : BasePresenter<MainScreenView>() {

    fun onPersonClick(){
        view?.goToPersonScreen()
    }

    fun onStatisticClick() = view?.goToStatisticScreen()

    fun onKlimatClick() = view?.goToKlimatScreen()

    fun onNewRoomClick() = view?.goToNewRoomScreen()
}