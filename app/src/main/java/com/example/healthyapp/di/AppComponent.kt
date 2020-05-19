package com.example.healthyapp.di

import android.content.Context
import com.example.healthyapp.features.auth.AuthenticationPresenter
import com.example.healthyapp.features.information.placementList.InfoPresenter
import com.example.healthyapp.features.information.placementInfo.PlacementInfoPresenter
import com.example.healthyapp.features.main_screen.MainScreenPresenter
import com.example.healthyapp.features.person.PersonPresenter
import com.example.healthyapp.features.person.RoomNumberPresenter
import com.example.healthyapp.features.person.WorkplacePresenter
import com.example.healthyapp.features.registration.RegistrationPresenter
import com.example.healthyapp.features.roomEdit.NewPlacementPresenter
import com.example.healthyapp.features.statistic.StatisticPresenter
import com.example.healthyapp.main.MainPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun context(): Context

    fun mainPresenter(): MainPresenter

    fun mainScreenPresenter(): MainScreenPresenter

    fun roomNumberPresenter(): RoomNumberPresenter

    fun personPresenter(): PersonPresenter

    fun workplacePresenter(): WorkplacePresenter

    fun authenticationPresenter(): AuthenticationPresenter

    fun newPlacementPresenter(): NewPlacementPresenter

    fun registrationPresenter(): RegistrationPresenter

    fun statisticPresenter(): StatisticPresenter

    fun infoPresenter(): InfoPresenter

    fun placementInfoPresenter(): PlacementInfoPresenter

}