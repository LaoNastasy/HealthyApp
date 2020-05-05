package com.example.healthyapp.features.person

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseFragment
import com.example.healthyapp.di.DI
import kotlinx.android.synthetic.main.fragment_room_number.*

class RoomNumberFragment : BaseFragment<RoomNumberPresenter, RoomNumberView>(), RoomNumberView {

    override fun initPresenter() = DI.component.roomNumberPresenter()

    override fun getMvpView() = this

    private lateinit var adapter: ArrayAdapter<String>
    private var selected: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_room_number, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter =
            ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item)
        room_number_choice_spinner.adapter = adapter
        presenter.getRoomNumbers()
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
    }

    override fun showNumbers(list: List<Long>) {
        adapter.clear()
        adapter.addAll(list.map { it.toString() })
    }
}