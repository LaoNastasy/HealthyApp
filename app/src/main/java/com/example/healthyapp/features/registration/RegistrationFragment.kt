package com.example.healthyapp.features.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseFragment
import com.example.healthyapp.di.DI
import com.example.healthyapp.navigation.Navigator
import kotlinx.android.synthetic.main.fragment_registration.view.*
import javax.inject.Inject

class RegistrationFragment : BaseFragment<RegistrationPresenter, RegistrationView>(),
    RegistrationView {

    @Inject
    lateinit var registrationPresenter: RegistrationPresenter

    init {
        DI.component.injectRegistrationFragment(this)
    }

    override fun initPresenter() = registrationPresenter

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

        return view
    }

    override fun goToMainFragment() {
        (activity as Navigator).goToBaseRoomEditScreen()
    }

    override fun showError() {
        Toast.makeText(context, getString(R.string.registration_error), Toast.LENGTH_SHORT).show()
    }
}