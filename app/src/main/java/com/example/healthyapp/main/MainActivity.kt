package com.example.healthyapp.main

import android.os.Bundle
import androidx.navigation.findNavController
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseActivity
import com.example.healthyapp.di.DI

class MainActivity : BaseActivity<MainPresenter, MainView>(), MainView {

    override fun initPresenter() = DI.component.mainPresenter()

    override fun getMvpView() = this


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.checkAuth()
    }

    override fun goToAuthScreen() {
        findNavController(R.id.fragment).navigate(R.id.loginFragment)
    }

    override fun goToMainScreen() {
        findNavController(R.id.fragment).navigate(R.id.mainFragment)
    }

}
