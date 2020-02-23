package com.example.healthyapp.features.roomEdit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_base_edit.view.*

class BaseRoomEditFragment : BaseFragment<RoomEditPresenter, RoomEditView>(), RoomEditView {

    override fun initPresenter() = RoomEditPresenter()

    override fun getMvpView() = this

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_base_edit, container, false)

        view.base_edit_save.setOnClickListener { presenter.saveRoom() }

        return view
    }

    override fun showError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}