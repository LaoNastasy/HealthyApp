package com.example.healthyapp.features.main_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        val action = MainFragmentDirections.actionMainFragmentToRoomNumberFragment()
        findNavController().navigate(action)
    }

    override fun goToStatisticScreen() {
        val action = MainFragmentDirections.actionMainFragmentToStatisticFragment()
        findNavController().navigate(action)
    }

    override fun goToNewRoomScreen() {
        val action = MainFragmentDirections.actionMainFragmentToRoomEditFragment()
        findNavController().navigate(action)
    }

    override fun logOut() {
        val action = MainFragmentDirections.actionMainFragmentToLoginFragment()
        findNavController().navigate(action)
    }

}