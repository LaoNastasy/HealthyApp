package com.example.healthyapp

import android.app.Application
import com.example.healthyapp.di.DI

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        DI.init(applicationContext)

    }

}