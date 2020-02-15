package com.example.healthyapp.di

import android.content.Context

object DI {

    lateinit var component: AppComponent

    fun init(context: Context) {
        component = DaggerAppComponent.builder()
            .appModule(AppModule(context))
            .build()
    }
}