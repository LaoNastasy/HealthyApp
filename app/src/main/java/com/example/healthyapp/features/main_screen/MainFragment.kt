package com.example.healthyapp.features.main_screen

import com.example.healthyapp.base.BaseFragment
import com.example.healthyapp.di.DI
import javax.inject.Inject

class MainFragment : BaseFragment<MainScreenPresenter, MainScreenView>(), MainScreenView {

    @Inject
    lateinit var mainPresenter: MainScreenPresenter

    init {
        DI.component.injectMainScreenFragment(this)
    }

    override fun initPresenter() = mainPresenter
    override fun getMvpView() = this
}