package com.example.healthyapp.features.information.workplaceInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseFragment
import com.example.healthyapp.db.model.entity.Workplace
import com.example.healthyapp.db.model.entity.WorkplaceUser
import com.example.healthyapp.di.DI

class WorkplaceInfoFragment : BaseFragment<WorkplaceInfoPresenter, WorkplaceInfoView>(),
    WorkplaceInfoView {

    override fun initPresenter() = DI.component.workplaceInfoPresenter()

    override fun getMvpView() = this

    private lateinit var workplaceId: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_workplace_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        workplaceId = arguments?.getString("workplaceId") ?: ""
        presenter.getWorkplaceInfo(workplaceId)
    }

    override fun showUserInfo(workplaceUser: WorkplaceUser) {

    }

    override fun showWorkplaceInfo(workplace: Workplace) {

    }
}