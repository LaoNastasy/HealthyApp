package com.example.healthyapp.di

import com.example.healthyapp.features.auth.AuthenticationPresenter
import com.example.healthyapp.features.main_screen.MainScreenPresenter
import com.example.healthyapp.features.person.PersonPresenter
import com.example.healthyapp.features.person.WorkplacePresenter
import com.example.healthyapp.features.registration.RegistrationPresenter
import com.example.healthyapp.features.roomEdit.RoomEditPresenter
import com.example.healthyapp.features.statistic.StatisticPresenter
import com.example.healthyapp.features.workplace.WorkplaceListPresenter
import com.example.healthyapp.main.MainPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun mainPresenter(): MainPresenter

    fun mainScreenPresenter(): MainScreenPresenter

    fun personPresenter(): PersonPresenter

    fun workplacePresenter(): WorkplacePresenter

    fun authenticationPresenter(): AuthenticationPresenter

    fun roomEditPresenter(): RoomEditPresenter

    fun registrationPresenter(): RegistrationPresenter

    fun statisticPresenter(): StatisticPresenter

    fun worplaseListPresenter(): WorkplaceListPresenter

}