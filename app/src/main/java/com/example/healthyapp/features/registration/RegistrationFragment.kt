package com.example.healthyapp.features.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
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
        activity?.window?.navigationBarColor =
            ContextCompat.getColor(requireContext(), R.color.colorAccent)

        view.registrate.setOnClickListener {
            presenter.registrate(
                view.login.text.toString(),
                view.password.text.toString()
            )
        }
        view.back.setOnClickListener {
            findNavController().popBackStack()
        }

        return view
    }

    override fun goToMainScreen() {
        val action = RegistrationFragmentDirections.actionRegisterFragmentToMainFragment()
        findNavController().navigate(action)
    }

}