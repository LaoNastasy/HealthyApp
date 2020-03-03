package com.example.healthyapp.features.klimat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseFragment
import com.example.healthyapp.di.DI
import javax.inject.Inject

class ClimateFragment : BaseFragment<ClimatePresenter, ClimateView>(), ClimateView {

    @Inject
    lateinit var climatePresenter: ClimatePresenter

    init {
        DI.component.injectClimateFragment(this)
    }

    override fun initPresenter() = climatePresenter

    override fun getMvpView() = this

    override fun goBack() {
        Navigation.findNavController(view ?: return).popBackStack()
    }

    override fun showError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_klimat, container, false)

        return view
    }
}