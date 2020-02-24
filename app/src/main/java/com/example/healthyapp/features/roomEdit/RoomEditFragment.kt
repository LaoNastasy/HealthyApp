package com.example.healthyapp.features.roomEdit

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseFragment
import com.example.healthyapp.db.model.entity.Placement
import com.example.healthyapp.di.DI
import kotlinx.android.synthetic.main.fragment_base_edit.view.*

class RoomEditFragment : BaseFragment<RoomEditPresenter, RoomEditView>(), RoomEditView {

    override fun initPresenter() = DI.component.roomEditPresenter()

    override fun getMvpView() = this

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_base_edit, container, false)

        view.base_edit_save.setOnClickListener {
            presenter.saveRoom(
                Placement(
                    id = 0,
                    number = view.room_number_edit.text.toString().toInt(),
                    length = view.room_length_edit.text.toString().toInt(),
                    height = view.room_height_edit.text.toString().toInt(),
                    width = view.room_width_edit.text.toString().toInt()
                )
            )
        }

        return view
    }

    override fun showAddWorkplaceDialog() {
        val dialog = AlertDialog.Builder(context ?: return)
            .setMessage(R.string.alert_need_add_workplace)
            .setNegativeButton(R.string.no) { dialog, _ -> dialog.dismiss() }
            .setPositiveButton(R.string.yes) { dialog, _ ->
                dialog.dismiss()
                showChooseDialog()
            }
            .setOnDismissListener {
                navigator.goBack()
            }.create()
        dialog.show()
    }

    private fun showChooseDialog() {
        var choise = -1
        val dialog = AlertDialog.Builder(context ?: return)
            .setTitle(R.string.add)
            .setSingleChoiceItems(
                arrayOf(getString(R.string.exist_workplace), getString(R.string.new_workplace)),
                -1
            ) { _, i ->
                choise = i
            }
            .setPositiveButton(R.string.ok) { dialogInterface, i ->
                when (choise) {
                    0 -> dialogInterface.dismiss()
                    1 -> {
                        dialogInterface.dismiss()
                        navigator.goToPersonScreen(
                            presenter.getRoomNumber() ?: return@setPositiveButton
                        )
                    }
                }
            }
            .setNegativeButton(R.string.cancel) { dialogInterface, _ ->
                dialogInterface.dismiss()
            }
            .create()
        dialog.show()
    }

    override fun showError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}