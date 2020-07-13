package com.example.healthyapp.features.information.placementList

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseFragment
import com.example.healthyapp.db.model.entity.Placement
import com.example.healthyapp.di.DI
import kotlinx.android.synthetic.main.fragment_info.*
import kotlinx.android.synthetic.main.fragment_info.view.*

class InfoFragment : BaseFragment<InfoPresenter, InfoView>(R.layout.fragment_info),
    InfoView {

    override fun initPresenter() = DI.component.infoPresenter()

    override fun getMvpView() = this

    private lateinit var adapter: PlacementAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter =
            PlacementAdapter {
                goToPlacementInfo(it)
            }
        placement_list.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapter
        }
        presenter.getPlacementList()

        view.back.setOnClickListener { findNavController().popBackStack() }

    }

    private fun goToPlacementInfo(placement: Placement) {
        val action =
            InfoFragmentDirections.actionInfoFragmentToPlacementInfoFragment(
                placement.id
            )
        findNavController().navigate(action)
    }

    override fun showPlacementList(list: List<Placement>) {
        adapter.setItems(list)
    }
}