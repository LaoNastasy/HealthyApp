package com.example.healthyapp.di

import com.example.healthyapp.UserRepository
import com.example.healthyapp.db.Database
import dagger.Component

@Component(modules = [AppModule::class])
interface DatabaseComponent {

    fun getDatabase(): Database

    fun getUserRepo(): UserRepository

}