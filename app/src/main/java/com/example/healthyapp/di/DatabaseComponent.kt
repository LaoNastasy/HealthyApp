package com.example.healthyapp.di

import com.example.healthyapp.auth.AuthenticationFragment
import com.example.healthyapp.auth.AuthenticationPresenter
import com.example.healthyapp.main.MainActivity
import com.example.healthyapp.main.MainPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface DatabaseComponent {

    fun injectMainActivity(mainActivity: MainActivity)

    fun injectAuthFragment(authFragment: AuthenticationFragment)

    fun mainPresenter(): MainPresenter

    fun authPresenter(): AuthenticationPresenter
}