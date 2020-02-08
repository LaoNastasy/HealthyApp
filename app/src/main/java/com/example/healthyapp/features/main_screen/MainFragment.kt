package com.example.healthyapp.features.main_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseFragment
import com.example.healthyapp.di.DI
import com.example.healthyapp.navigation.Navigator
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

    override fun goToPersonScreen() = (activity as Navigator).goToPersonScreen()

    override fun goToStatisticScreen() = (activity as Navigator).goToStatisticScreen()

    override fun goToNewRoomScreen() = (activity as Navigator).goToBaseRoomEditScreen()

    override fun goToClimateScreen() = (activity as Navigator).goToKlimatScreen()

    override fun logOut() = (activity as Navigator).goToAuthScreen()

    override fun showError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}