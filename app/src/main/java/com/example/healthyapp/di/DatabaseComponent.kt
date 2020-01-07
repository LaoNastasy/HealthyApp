package com.example.healthyapp.di

import com.example.healthyapp.features.auth.AuthenticationFragment
import com.example.healthyapp.features.auth.AuthenticationPresenter
import com.example.healthyapp.features.main_screen.MainFragment
import com.example.healthyapp.features.main_screen.MainScreenPresenter
import com.example.healthyapp.main.MainActivity
import com.example.healthyapp.main.MainPresenter
import com.example.healthyapp.features.registration.RegistrationFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface DatabaseComponent {

    fun injectMainActivity(mainActivity: MainActivity)

    fun injectAuthFragment(authFragment: AuthenticationFragment)

    fun injectRegistrationFragment(registrationFragment: RegistrationFragment)

    fun injectMainScreenFragment(fragment: MainFragment)

    fun mainPresenter(): MainPresenter

    fun authPresenter(): AuthenticationPresenter

    fun mainScreenPresenter(): MainScreenPresenter
}