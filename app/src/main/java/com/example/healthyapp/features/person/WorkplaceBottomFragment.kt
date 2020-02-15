package com.example.healthyapp.features.person

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseBottomFragment
import com.example.healthyapp.db.model.entity.Workplace
import com.example.healthyapp.di.DI
import kotlinx.android.synthetic.main.bottom_fragment_new_workplace.view.*
import javax.inject.Inject

class WorkplaceBottomFragment : BaseBottomFragment<WorkplacePresenter, WorkplaceView>(),
    WorkplaceView {

    @Inject
    lateinit var workplacePresenter: WorkplacePresenter

    init {
        DI.component.injectWorkplaceFragment(this)
    }

    override fun initPresenter(): WorkplacePresenter = workplacePresenter

    override fun getMvpView() = this

    private lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.bottom_fragment_new_workplace, container, false)
        presenter.getCurrentWorkplace()
        return rootView
    }


    override fun showWorkplace(workplace: Workplace) {
        rootView.workplace_table_height.text = workplace.tableHeight.toString()
        rootView.workplace_chair_height.text = workplace.chairHeight.toString()
        rootView.workplace_keyboard_height.text = workplace.keyboardHeight.toString()
        rootView.workplace_monitor_height.text = workplace.monitorHeight.toString()
        rootView.workplace_stand_height.text = workplace.standHeight.toString()
    }

    override fun showError() {
        showError(getString(R.string.common_error))


    }
}