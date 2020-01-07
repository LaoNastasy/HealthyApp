package com.example.healthyapp.features.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseFragment
import com.example.healthyapp.di.DI
import com.example.healthyapp.navigation.Navigator
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
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun goToMainFragment() {
        (activity as Navigator).goToBaseRoomEditScreen()
    }
}