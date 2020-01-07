package com.example.healthyapp.features.roomEdit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseFragment

class BaseRoomEditFragment : BaseFragment<RoomEditPresenter, RoomEditView>(), RoomEditView {

    override fun initPresenter() = RoomEditPresenter()

    override fun getMvpView() = this

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_base_edit, container, false)

        return view
    }
}