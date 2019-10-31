package com.example.healthyapp.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.healthyapp.*
import com.example.healthyapp.auth.AuthenticationFragment
import com.example.healthyapp.base.BaseFragment
import com.example.healthyapp.base.BaseRoomEditFragment
import com.example.healthyapp.navigation.Navigator

class MainActivity : AppCompatActivity(), Navigator, MainView {

   private lateinit var presenter : MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenter()
        presenter.checkAuth()
    }

    override fun goToBaseRoomEditScreen() {
        goToFragment(BaseRoomEditFragment())
    }

    override fun goToAuthFragment() {
        goToFragment(AuthenticationFragment())
    }

    private fun goToFragment(fragment: BaseFragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_place, fragment).commit()
    }
}
