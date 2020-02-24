package com.example.healthyapp.navigation

interface Navigator {

    fun goToBaseRoomEditScreen()
    fun goToAuthScreen()
    fun goToRegistrationScreen()
    fun goToPersonScreen(roomNumber:Int = 0)
    fun goToWorkplaceScreen()
    fun goToStatisticScreen()
    fun goToClimateScreen()
    fun goToMainScreen()
    fun goBack()
}