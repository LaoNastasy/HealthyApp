package com.example.healthyapp.di

import android.content.Context

object DI {

    lateinit var component: DatabaseComponent

    fun init(context: Context) {
        component = DaggerDatabaseComponent.builder()
            .appModule(AppModule(context))
            .build()
    }
}