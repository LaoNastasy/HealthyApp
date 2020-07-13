package com.example.healthyapp.features.statistic

import android.os.Bundle
import android.view.View
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseFragment
import com.example.healthyapp.di.DI
import kotlinx.android.synthetic.main.fragment_try_flow.*

class StatisticFragment :
    BaseFragment<StatisticPresenter, StatisticView>(R.layout.fragment_try_flow), StatisticView {

    override fun initPresenter() = DI.component.statisticPresenter()

    override fun getMvpView() = this

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        motion_layout.setTransitionListener(object : TransitionAdapter() {

            override fun onTransitionCompleted(motionLayout: MotionLayout, currentId: Int) {
                when (currentId) {
                    R.id.end_off -> {
                        motionLayout.progress = 0f
                        motionLayout.setTransition(R.id.start, R.id.to_start)
                    }
                }
            }

        })
    }

}