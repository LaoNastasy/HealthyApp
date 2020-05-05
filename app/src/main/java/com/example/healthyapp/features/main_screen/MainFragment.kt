package com.example.healthyapp.features.main_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseFragment
import com.example.healthyapp.di.DI
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment : BaseFragment<MainScreenPresenter, MainScreenView>(), MainScreenView {

    override fun initPresenter() = DI.component.mainScreenPresenter()
    override fun getMvpView() = this

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        view.person.setOnClickListener { presenter.onPersonClick() }
        view.statistic.setOnClickListener { presenter.onStatisticClick() }
        view.kabinet.setOnClickListener { presenter.onNewRoomClick() }
        view.exit.setOnClickListener { presenter.logOut() }

        return view
    }

    override fun goToPersonScreen() {
        findNavController().navigate(R.id.roomNumberFragment)
    }

    override fun goToStatisticScreen() {
        findNavController().navigate(R.id.statisticFragment)
    }

    override fun goToNewRoomScreen() {
        findNavController().navigate(R.id.roomEditFragment)
    }

    override fun logOut() {
        findNavController().navigate(R.id.loginFragment)
    }

}