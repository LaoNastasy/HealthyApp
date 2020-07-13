package com.example.healthyapp.features.auth

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseFragment
import com.example.healthyapp.di.DI
import kotlinx.android.synthetic.main.fragment_authentification.*

class AuthenticationFragment :
    BaseFragment<AuthenticationPresenter, AuthenticationView>(R.layout.fragment_authentification),
    AuthenticationView {

    override fun initPresenter() = DI.component.authenticationPresenter()

    override fun getMvpView() = this

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.window?.navigationBarColor =
            ContextCompat.getColor(requireContext(), R.color.colorAccent)

        ok.setOnClickListener {
            presenter.login(
                login.text.toString(),
                password.text.toString()
            )
        }

        registrate.setOnClickListener {
            val action = AuthenticationFragmentDirections.actionLoginFragmentToRegisterFragment()
            findNavController().navigate(action)
        }
    }

    override fun goToMainScreen() {
        val action = AuthenticationFragmentDirections.actionLoginFragmentToMainFragment()
        findNavController().navigate(action)
    }

    override fun showLoading(show: Boolean) {
        loader.visibility = if (show) View.VISIBLE else View.GONE
        ok.isEnabled = !show
    }

}