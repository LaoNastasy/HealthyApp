package com.example.healthyapp.features.main_screen

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseFragment
import com.example.healthyapp.di.DI
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment<MainScreenPresenter, MainScreenView>(R.layout.fragment_main), MainScreenView {

    override fun initPresenter() = DI.component.mainScreenPresenter()
    override fun getMvpView() = this

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.window?.navigationBarColor =
            ContextCompat.getColor(requireContext(), R.color.colorPrimary)
        add_workplace.setOnClickListener { presenter.onPersonClick() }
        //statistic.setOnClickListener { presenter.onStatisticClick() }
        add_placement.setOnClickListener { presenter.onNewRoomClick() }
        info.setOnClickListener { presenter.onInfoClick() }
        logout.setOnClickListener { presenter.logOut() }

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
        val action = MainFragmentDirections.actionMainFragmentToNewPlacementFragment()
        findNavController().navigate(action)
    }

    override fun logOut() {
        val action = MainFragmentDirections.actionMainFragmentToLoginFragment()
        findNavController().navigate(action)
    }

    override fun goToInfoScreen() {
        val action = MainFragmentDirections.actionMainFragmentToInfoFragment()
        findNavController().navigate(action)
    }

}