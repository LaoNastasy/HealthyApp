package com.example.healthyapp.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseActivity
import com.example.healthyapp.di.DI
import com.example.healthyapp.features.auth.AuthenticationFragment
import com.example.healthyapp.features.klimat.ClimateFragment
import com.example.healthyapp.features.person.PersonFragment
import com.example.healthyapp.features.registration.RegistrationFragment
import com.example.healthyapp.features.roomEdit.RoomEditFragment
import com.example.healthyapp.features.statistic.StatisticFragment
import com.example.healthyapp.navigation.Navigator

class MainActivity : BaseActivity<MainPresenter, MainView>(), Navigator, MainView {

    override fun initPresenter() = DI.component.mainPresenter()

    override fun getMvpView() = this


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.checkAuth()
    }

    override fun goToBaseRoomEditScreen() {
        goToFragment(RoomEditFragment(), true)
    }

    override fun goToAuthScreen() {
        goToFragment(AuthenticationFragment())
    }

    override fun showError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun goToRegistrationScreen() {
        goToFragment(RegistrationFragment())
    }

    override fun goToPersonScreen(roomNumber: Int) {
        val bundle = Bundle()
        bundle.putInt(PersonFragment::class.simpleName, roomNumber)
        findNavController(R.id.fragment).navigate(R.id.action_mainFragment_to_personFragment2, bundle)
    }

    override fun goToWorkplaceScreen() {
        findNavController(R.id.fragment).navigate(R.id.workplaceBottomFragment)
    }

    override fun goToStatisticScreen() {
        goToFragment(StatisticFragment(), true)
    }

    override fun goToClimateScreen() {
        goToFragment(ClimateFragment(), true)
    }

    override fun goToMainScreen() {
        //   findNavController(R.id.fragment).navigate(R.id.mainFragment)
    }

    override fun goBack() {
        supportFragmentManager.popBackStack()
    }

    private fun goToFragment(fragment: Fragment, addToBackStack: Boolean = false) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment, fragment)
        if (addToBackStack) fragmentTransaction.addToBackStack(fragment::class.java.name)
        fragmentTransaction.commit()
    }
}
