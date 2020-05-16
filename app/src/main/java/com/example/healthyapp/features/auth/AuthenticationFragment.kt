package com.example.healthyapp.features.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseFragment
import com.example.healthyapp.di.DI
import kotlinx.android.synthetic.main.fragment_authentification.*
import kotlinx.android.synthetic.main.fragment_authentification.view.*

class AuthenticationFragment : BaseFragment<AuthenticationPresenter, AuthenticationView>(),
    AuthenticationView {

    override fun initPresenter() = DI.component.authenticationPresenter()

    override fun getMvpView() = this

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_authentification, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.ok.setOnClickListener {
            presenter.login(
                login.text.toString(),
                password.text.toString()
            )
        }

        view.registrate.setOnClickListener {
            val action = AuthenticationFragmentDirections.actionLoginFragmentToRegisterFragment()
            findNavController().navigate(action)
        }
    }

    override fun goToMainScreen() {
        val action = AuthenticationFragmentDirections.actionLoginFragmentToMainFragment()
        findNavController().navigate(action)
    }

}