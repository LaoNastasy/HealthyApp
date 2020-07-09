package com.example.healthyapp.features.newWorkplace.workplace

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseFragment
import com.example.healthyapp.db.model.entity.Workplace
import com.example.healthyapp.di.DI
import kotlinx.android.synthetic.main.fragment_new_workplace.view.*

class WorkplaceFragment : BaseFragment<WorkplacePresenter, WorkplaceView>(),
    WorkplaceView {

    override fun initPresenter() = DI.component.workplacePresenter()

    override fun getMvpView() = this

    private lateinit var rootView: View
    private lateinit var workplace: Workplace

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_new_workplace, container, false)
        rootView.workplace_save.setOnClickListener { presenter.saveWorkplace() }
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getCurrentWorkplace()
        navController = findNavController()
    }


    override fun showWorkplace(workplace: Workplace) {
        this.workplace = workplace
        rootView.workplace_table_height.text = workplace.tableHeight.toString()
        rootView.workplace_chair_height.text = workplace.chairHeight.toString()
        rootView.workplace_monitor_height.text = workplace.monitorHeight.toString()
        rootView.workplace_stand_height.text = workplace.standHeight.toString()
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