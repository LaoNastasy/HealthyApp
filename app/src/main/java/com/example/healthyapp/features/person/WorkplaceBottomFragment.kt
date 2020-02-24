package com.example.healthyapp.features.person

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseBottomFragment
import com.example.healthyapp.db.model.entity.Workplace
import com.example.healthyapp.di.DI
import kotlinx.android.synthetic.main.bottom_fragment_new_workplace.view.*

class WorkplaceBottomFragment : BaseBottomFragment<WorkplacePresenter, WorkplaceView>(),
    WorkplaceView {

    override fun initPresenter() = DI.component.workplacePresenter()

    override fun getMvpView() = this

    private lateinit var rootView: View
    private lateinit var workplace: Workplace

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.bottom_fragment_new_workplace, container, false)
        rootView.workplace_save.setOnClickListener { presenter.saveWorkplace() }
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getCurrentWorkplace()
    }


    override fun showWorkplace(workplace: Workplace) {
        this.workplace = workplace
        rootView.workplace_table_height.text = workplace.tableHeight.toString()
        rootView.workplace_chair_height.text = workplace.chairHeight.toString()
        rootView.workplace_keyboard_height.text = workplace.keyboardHeight.toString()
        rootView.workplace_monitor_height.text = workplace.monitorHeight.toString()
        rootView.workplace_stand_height.text = workplace.standHeight.toString()
    }

    override fun showSuccessSaveDialog() {
        AlertDialog.Builder(context)
            .setMessage(R.string.success_save_workplace)
            .setPositiveButton(R.string.yes) { dialogInterface, _ ->
                dialogInterface.dismiss()
                dismiss()
                navigator.goToPersonScreen(workplace.roomNumber)
            }
            .setNegativeButton(R.string.no) { dialogInterface, _ ->
                dialogInterface.dismiss()
                dismiss()
                navigator.goToMainScreen()
            }
            .setOnDismissListener { navigator.goBack() }
            .show()
    }

    override fun showError() {
        showError(getString(R.string.common_error))


    }
}