package com.example.healthyapp.features.statistic

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
}