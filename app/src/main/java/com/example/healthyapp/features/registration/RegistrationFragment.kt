package com.example.healthyapp.features.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseFragment
import com.example.healthyapp.di.DI
import kotlinx.android.synthetic.main.fragment_registration.view.*

class RegistrationFragment : BaseFragment<RegistrationPresenter, RegistrationView>(),
    RegistrationView {

    override fun initPresenter() = DI.component.registrationPresenter()

    override fun getMvpView() = this

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_registration, container, false)

        view.registrate.setOnClickListener {
            presenter.registrate(
                view.login.text.toString(),
                view.password.text.toString()
            )
        }
        view.back.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.loginFragment)
        }

        return view
    }

    override fun goToMainScreen() {
        Navigation.findNavController(view?:return).navigate(R.id.mainFragment)
    }

}