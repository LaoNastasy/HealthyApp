package com.example.healthyapp.features.main_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseFragment
import com.example.healthyapp.di.DI
import kotlinx.android.synthetic.main.fragment_main.view.*
import javax.inject.Inject

class MainFragment : BaseFragment<MainScreenPresenter, MainScreenView>(), MainScreenView {

    @Inject
    lateinit var mainPresenter: MainScreenPresenter

    init {
        DI.component.injectMainScreenFragment(this)
    }

    override fun initPresenter() = mainPresenter
    override fun getMvpView() = this

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        view.person.setOnClickListener { presenter.onPersonClick() }
        view.climate.setOnClickListener { presenter.onClimateClick() }
        view.statistic.setOnClickListener { presenter.onStatisticClick() }
        view.kabinet.setOnClickListener { presenter.onNewRoomClick() }
        view.exit.setOnClickListener { presenter.logOut() }

        return view
    }

    override fun goToPersonScreen() = navigator.goToPersonScreen()

    override fun goToStatisticScreen() = navigator.goToStatisticScreen()

    override fun goToNewRoomScreen() = navigator.goToBaseRoomEditScreen()

    override fun goToClimateScreen() = navigator.goToClimateScreen()

    override fun logOut() = navigator.goToAuthScreen()

    override fun showError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}