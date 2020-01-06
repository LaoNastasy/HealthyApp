package com.example.healthyapp.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseFragment

class RegistrationFragment:BaseFragment<RegistrationPresenter, RegistrationView>(), RegistrationView {


    override fun initPresenter(): RegistrationPresenter {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMvpView()= this

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }
}