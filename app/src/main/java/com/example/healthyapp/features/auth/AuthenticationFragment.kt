package com.example.healthyapp.features.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.healthyapp.base.BaseFragment
import com.example.healthyapp.R
import com.example.healthyapp.di.DI
import com.example.healthyapp.navigation.Navigator
import kotlinx.android.synthetic.main.fragment_authentification.*
import kotlinx.android.synthetic.main.fragment_authentification.view.*
import javax.inject.Inject

class AuthenticationFragment : BaseFragment<AuthenticationPresenter, AuthenticationView>(),
    AuthenticationView {

    @Inject
    lateinit var authPresenter: AuthenticationPresenter

    init {
        DI.component.injectAuthFragment(this)
    }

    override fun initPresenter() = authPresenter

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
            presenter.onRegistrationClick()
        }
    }

    override fun goToMainScreen() {
        (activity as Navigator).goToMainScreen()
    }

    override fun gotoRegistration() {
        (activity as Navigator).goToRegistrationScreen()
    }

    override fun showError() {
        Toast.makeText(context,getString(R.string.wrong_password), Toast.LENGTH_SHORT).show()
    }
}