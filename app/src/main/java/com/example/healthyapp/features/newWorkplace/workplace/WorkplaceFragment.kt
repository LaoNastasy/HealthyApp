package com.example.healthyapp.features.newWorkplace.workplace

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseFragment
import com.example.healthyapp.db.model.entity.Workplace
import com.example.healthyapp.di.DI
import kotlinx.android.synthetic.main.fragment_new_workplace.*

class WorkplaceFragment : BaseFragment<WorkplacePresenter, WorkplaceView>(R.layout.fragment_new_workplace),
    WorkplaceView {

    override fun initPresenter() = DI.component.workplacePresenter()

    override fun getMvpView() = this

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getCurrentWorkplace()
        workplace_save.setOnClickListener { presenter.saveWorkplace() }
    }


    override fun showWorkplace(workplace: Workplace) {
        workplace_table_height.text = workplace.tableHeight.toString()
        workplace_chair_height.text = workplace.chairHeight.toString()
        workplace_monitor_height.text = workplace.monitorHeight.toString()
        workplace_stand_height.text = workplace.standHeight.toString()
    }

    override fun showSuccessSaveDialog() {
        AlertDialog.Builder(context)
            .setMessage(R.string.success_save_workplace)
            .setPositiveButton(R.string.yes) { dialogInterface, _ ->
                dialogInterface.dismiss()
            }

            .setOnDismissListener {
                findNavController().popBackStack()
            }
            .show()
    }

}