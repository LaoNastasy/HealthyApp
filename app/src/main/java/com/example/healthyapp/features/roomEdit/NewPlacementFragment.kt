package com.example.healthyapp.features.roomEdit

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseFragment
import com.example.healthyapp.db.model.entity.Placement
import com.example.healthyapp.di.DI
import kotlinx.android.synthetic.main.fragment_new_placement.*
import kotlinx.android.synthetic.main.fragment_new_placement.view.*

class NewPlacementFragment : BaseFragment<NewPlacementPresenter, NewPlacementView>(R.layout.fragment_new_placement),
    NewPlacementView {

    override fun initPresenter() = DI.component.newPlacementPresenter()

    override fun getMvpView() = this

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        base_edit_save.setOnClickListener {
            presenter.saveRoom(
                Placement(
                    id = "",
                    number = view.room_number_edit.text.toString().toLong(),
                    length = view.room_length_edit.text.toString().toLong(),
                    height = view.room_height_edit.text.toString().toLong(),
                    width = view.room_width_edit.text.toString().toLong()
                )
            )
        }
    }

    override fun showAddWorkplaceDialog() {
        val dialog = AlertDialog.Builder(context ?: return)
            .setMessage(R.string.alert_need_add_workplace)
//            .setNegativeButton(R.string.no) { dialog, _ ->
//                dialog.dismiss()
//                findNavController().popBackStack()
//            }
            .setPositiveButton(R.string.ok) { dialog, _ ->
                dialog.dismiss()
                findNavController().popBackStack()
            }
            .create()
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
            .setPositiveButton(R.string.ok) { dialogInterface, _ ->
                when (choise) {
                    0 -> dialogInterface.dismiss()
                    1 -> {
                        dialogInterface.dismiss()
                        val action =
                            NewPlacementFragmentDirections.actionNewPlacementFragmentToPersonFragment(
                                presenter.getPlacementId()
                            )
                        findNavController().navigate(action)
                    }
                }
            }
            .setNegativeButton(R.string.cancel) { dialogInterface, _ ->
                dialogInterface.dismiss()
            }
            .create()
        dialog.show()
    }

}