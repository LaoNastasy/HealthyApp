package com.example.healthyapp.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.healthyapp.R
import com.example.healthyapp.di.DI

class MainActivity : AppCompatActivity(), MainView {

    val presenter = DI.component.mainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.attachView(this)
        presenter.checkAuth()
    }

    override fun goToAuthScreen() {
        findNavController(R.id.fragment).navigate(R.id.loginFragment)
    }

    override fun goToMainScreen() {
        findNavController(R.id.fragment).navigate(R.id.mainFragment)
    }

}
