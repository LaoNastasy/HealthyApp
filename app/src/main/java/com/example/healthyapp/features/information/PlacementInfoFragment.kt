package com.example.healthyapp.features.information

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseFragment
import com.example.healthyapp.di.DI

class PlacementInfoFragment : BaseFragment<PlacementInfoPresenter, PlacementInfoView>(),
    PlacementInfoView {

    override fun getMvpView() = this

    override fun initPresenter() = DI.component.placementInfoPresenter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_placement_info, container, false)


        return view
    }
}