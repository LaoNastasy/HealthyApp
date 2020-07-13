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
import kotlinx.android.synthetic.main.fragment_registration.*
import kotlinx.android.synthetic.main.fragment_registration.view.*

class RegistrationFragment : BaseFragment<RegistrationPresenter, RegistrationView>(R.layout.fragment_registration),
    RegistrationView {

    override fun initPresenter() = DI.component.registrationPresenter()

    override fun getMvpView() = this

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.window?.navigationBarColor =
            ContextCompat.getColor(requireContext(), R.color.colorAccent)

        registrate.setOnClickListener {
            presenter.register(
                view.login.text.toString(),
                view.password.text.toString(),
                view.password_repeated.text.toString()
            )
        }
        back.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun goToMainScreen() {
        val action = RegistrationFragmentDirections.actionRegisterFragmentToMainFragment()
        findNavController().navigate(action)
    }

    override fun showLoading(show: Boolean) {
        loader.visibility = if (show) View.VISIBLE else View.GONE
        registrate.isEnabled = !show
    }

}