package com.example.healthyapp.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.healthyapp.*
import com.example.healthyapp.auth.AuthenticationFragment
import com.example.healthyapp.base.BaseActivity
import com.example.healthyapp.roomEdit.BaseRoomEditFragment
import com.example.healthyapp.navigation.Navigator

class MainActivity : BaseActivity<MainPresenter, MainView>(), Navigator, MainView {


    override fun initPresenter() = MainPresenter()

    override fun getMvpView() = this


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.checkAuth()
    }

    override fun goToBaseRoomEditScreen() {
        goToFragment(BaseRoomEditFragment())
    }

    override fun goToAuthFragment() {
        goToFragment(AuthenticationFragment())
    }

    private fun goToFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_place, fragment).commit()
    }
}
