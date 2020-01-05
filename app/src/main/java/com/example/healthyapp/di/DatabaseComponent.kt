package com.example.healthyapp.di

import com.example.healthyapp.auth.AuthenticationFragment
import com.example.healthyapp.main.MainActivity
import dagger.Component

@Component(modules = [AppModule::class])
interface DatabaseComponent {

    fun injectMainActivity(mainActivity: MainActivity)

    fun injectAuthFragment(authFragment: AuthenticationFragment)

}