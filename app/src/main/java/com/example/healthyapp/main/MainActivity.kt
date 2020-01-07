package com.example.healthyapp.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.healthyapp.*
import com.example.healthyapp.features.auth.AuthenticationFragment
import com.example.healthyapp.features.registration.RegistrationFragment
import com.example.healthyapp.base.BaseActivity
import com.example.healthyapp.di.DI
import com.example.healthyapp.features.main_screen.MainFragment
import com.example.healthyapp.features.roomEdit.BaseRoomEditFragment
import com.example.healthyapp.features.statistic.StatisticFragment
import com.example.healthyapp.navigation.Navigator
import javax.inject.Inject

class MainActivity : BaseActivity<MainPresenter, MainView>(), Navigator, MainView {

    @Inject
    lateinit var mainPresenter: MainPresenter

    init {
        DI.component.injectMainActivity(this)
    }

    override fun initPresenter() = mainPresenter

    override fun getMvpView() = this


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.checkAuth()
    }

    override fun goToBaseRoomEditScreen() {
        goToFragment(BaseRoomEditFragment())
    }

    override fun goToAuthScreen() {
        goToFragment(AuthenticationFragment())
    }

    override fun goToRegistrationScreen() {
        goToFragment(RegistrationFragment())
    }

    override fun goToPersonScreen() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun goToStatisticScreen() {
        goToFragment(StatisticFragment())
    }

    override fun goToKlimatScreen() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun goToMainScreen() {
        goToFragment(MainFragment())
    }

    private fun goToFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_place, fragment).commit()
    }
}
