package com.example.healthyapp.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.healthyapp.R
import com.example.healthyapp.di.DI

class MainActivity : AppCompatActivity(R.layout.activity_main), MainView {

    val presenter = DI.component.mainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this)
        presenter.checkAuth()
    }

    override fun goToAuthScreen() {
        findNavController(R.id.fragment).navigate(R.id.loginFragment)
    }

    override fun goToMainScreen() {
        findNavController(R.id.fragment).navigate(R.id.mainFragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

}
