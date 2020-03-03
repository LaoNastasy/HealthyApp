package com.example.healthyapp.features.main_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseFragment
import com.example.healthyapp.di.DI
import com.example.healthyapp.navigation.Navigator
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
        Navigation.findNavController(view?:return).navigate(R.id.personFragment)
    }

    override fun goToStatisticScreen() {
        Navigation.findNavController(view?:return).navigate(R.id.statisticFragment)
    }

    override fun goToNewRoomScreen() {
        Navigation.findNavController(view?:return).navigate(R.id.roomEditFragment)
    }

    override fun logOut() {
        Navigation.findNavController(view?:return).navigate(R.id.loginFragment)
    }

    override fun showError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}