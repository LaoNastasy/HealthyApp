package com.example.healthyapp.features.klimat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseFragment
import com.example.healthyapp.di.DI
import com.example.healthyapp.navigation.Navigator
import javax.inject.Inject

class ClimateFragment : BaseFragment<ClimatePresenter, ClimateView>(), ClimateView {

    @Inject
    lateinit var climatePresenter: ClimatePresenter

    init {
        DI.component.injectClimateFragment(this)
    }

    override fun initPresenter() = ClimatePresenter()

    override fun getMvpView() = this

    override fun goBack() = (activity as Navigator).goToMainScreen()
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