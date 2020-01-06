package com.example.healthyapp.di

import com.example.healthyapp.auth.AuthenticationFragment
import com.example.healthyapp.auth.AuthenticationPresenter
import com.example.healthyapp.main.MainActivity
import com.example.healthyapp.main.MainPresenter
import com.example.healthyapp.registration.RegistrationFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface DatabaseComponent {

    fun injectMainActivity(mainActivity: MainActivity)

    fun injectAuthFragment(authFragment: AuthenticationFragment)

    fun injectRegistrationFragment(registrationFragment: RegistrationFragment)

    fun mainPresenter(): MainPresenter

    fun authPresenter(): AuthenticationPresenter
}