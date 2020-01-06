package com.example.healthyapp.auth

import com.example.healthyapp.base.BaseFragment

class RegistrationFragment:BaseFragment<RegistrationPresenter, RegistrationView>(), RegistrationView {


    override fun initPresenter(): RegistrationPresenter {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMvpView()= this
}