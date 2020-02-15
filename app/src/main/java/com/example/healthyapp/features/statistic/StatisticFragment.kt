package com.example.healthyapp.features.statistic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseFragment
import com.example.healthyapp.di.DI
import javax.inject.Inject

class StatisticFragment : BaseFragment<StatisticPresenter, StatisticView>(), StatisticView {

    @Inject
    lateinit var statisticPresenter: StatisticPresenter

    init {
        DI.component.injectStatisticFragment(this)
    }

    override fun initPresenter() = statisticPresenter

    override fun getMvpView() = this

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_statistic, container, false)

        return view
    }

    override fun showError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}