package com.example.healthyapp.features.information.workplaceInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseFragment
import com.example.healthyapp.db.model.entity.Workplace
import com.example.healthyapp.db.model.entity.WorkplaceUser
import com.example.healthyapp.di.DI
import kotlinx.android.synthetic.main.fragment_workplace_info.*

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
        back.setOnClickListener { findNavController().popBackStack() }
    }

    override fun showUserInfo(workplaceUser: WorkplaceUser) {
        workplace_user_back_value.text = workplaceUser.back.toString()
        workplace_user_height_value.text = workplaceUser.height.toString()
        workplace_user_leg_value.text = workplaceUser.legsHeight.toString()
        workplace_user_shoulder_value.text = workplaceUser.shoulder.toString()
        workplace_user_sit_height_value.text = workplaceUser.sitHeight.toString()
        workplace_user_name_value.text = workplaceUser.name
    }

    override fun showWorkplaceInfo(workplace: Workplace) {
        workplace_chair_value.text = workplace.chairHeight.toString()
        workplace_monitor_value.text = workplace.monitorHeight.toString()
        //workplace_placement_number.text = workplace.roomNumber.toString()
        workplace_stand_value.text = workplace.standHeight.toString()
        workplace_table_value.text = workplace.tableHeight.toString()
    }
}