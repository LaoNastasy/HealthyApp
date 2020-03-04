package com.example.healthyapp.features.statistic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseFragment
import com.example.healthyapp.di.DI
import kotlinx.android.synthetic.main.fragment_try_flow.view.*
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
        val view = inflater.inflate(R.layout.fragment_try_flow, container, false)


        view.motion_layout.setTransitionListener(object : TransitionAdapter() {

            override fun onTransitionCompleted(motionLayout: MotionLayout, currentId: Int) {
                when (currentId) {
                    R.id.end_off -> {
                        motionLayout.progress = 0f
                        motionLayout.setTransition(R.id.start, R.id.to_start)
                    }
                }
            }

        })
        return view
    }

    override fun showError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}