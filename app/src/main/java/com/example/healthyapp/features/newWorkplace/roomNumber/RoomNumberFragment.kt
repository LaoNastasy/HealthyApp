package com.example.healthyapp.features.newWorkplace.roomNumber

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseFragment
import com.example.healthyapp.di.DI
import kotlinx.android.synthetic.main.fragment_room_number.*

class RoomNumberFragment : BaseFragment<RoomNumberPresenter, RoomNumberView>(),
    RoomNumberView {

    override fun initPresenter() = DI.component.roomNumberPresenter()

    override fun getMvpView() = this

    private lateinit var adapter: ArrayAdapter<String>
    private var selected: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_room_number, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        back.setOnClickListener { findNavController().popBackStack() }

        adapter =
            ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item)
        room_number_choice_spinner.adapter = adapter
        room_number_choice_spinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    room_number_ready.isEnabled = false
                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    room_number_ready.isEnabled = true
                    selected = position
                }

            }

        room_number_ready.setOnClickListener {
            presenter.onItemSelected(selected ?: return@setOnClickListener)
        }

        presenter.getRoomNumbers()
    }

    override fun showNumbers(list: List<Long>) {
        adapter.clear()
        adapter.addAll(list.map { it.toString() })
    }

    override fun showWarning(res: Int) {
        AlertDialog.Builder(requireContext())
            .setPositiveButton(R.string.room_continue) { _, _ ->
                presenter.onSubmitWarning()
            }
            .setNegativeButton(R.string.cancel) { dialog: DialogInterface?, _ ->
                dialog?.dismiss()
            }
            .setMessage(res)
            .show()
    }

    override fun goNext(placementId: String) {
        val action =
            RoomNumberFragmentDirections.actionRoomNumberToPersonFragment(
                placementId
            )
        findNavController().navigate(action)
    }

    override fun showLoading(show: Boolean) {
        loader.visibility = if (show) View.VISIBLE else View.GONE
        room_number_ready.isEnabled = !show
    }
}