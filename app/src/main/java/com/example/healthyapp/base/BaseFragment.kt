package com.example.healthyapp.base

import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {

    protected lateinit var presenter: BasePresenter

    protected fun initPresenter(presenter: BasePresenter) {
        this.presenter = presenter
    }
}