package com.example.healthyapp.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        view.auth_button.setOnClickListener {
            presenter.login(
                login.text.toString(),
                password.text.toString()
            )
        }

        view.registration.setOnClickListener {
            presenter.onRegistrationClick()
        }
    }

    override fun goToBaseRoomEdit() {
        (activity as Navigator).goToBaseRoomEditFragment()
    }

    override fun gotoRegistration() {
        (activity as Navigator).goToRegistrationFragment()
    }

    override fun showError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}