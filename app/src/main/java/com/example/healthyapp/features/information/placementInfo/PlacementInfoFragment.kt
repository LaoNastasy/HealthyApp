package com.example.healthyapp.features.information.placementInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseFragment
import com.example.healthyapp.db.model.entity.Placement
import com.example.healthyapp.db.model.entity.Workplace
import com.example.healthyapp.di.DI
import kotlinx.android.synthetic.main.fragment_placement_info.*
import kotlinx.android.synthetic.main.fragment_placement_info.view.*

class PlacementInfoFragment : BaseFragment<PlacementInfoPresenter, PlacementInfoView>(),
    PlacementInfoView {

    override fun getMvpView() = this

    override fun initPresenter() = DI.component.placementInfoPresenter()

    private lateinit var adapter: WorkplaceAdapter
    private lateinit var placementId: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_placement_info, container, false)
        placementId = arguments?.getString("placementId") ?: ""
        adapter =
            WorkplaceAdapter {}
        view.back.setOnClickListener { findNavController().popBackStack() }
        view.placement_workplace_list.layoutManager = LinearLayoutManager(requireContext())
        view.placement_workplace_list.adapter = adapter
        presenter.getWorkplaces(placementId)
        presenter.getPlacementInfo(placementId)


        return view
    }

    override fun showWorkplaces(list: List<Workplace>) {
        adapter.setList(list)
        placement_workplace_count.visibility = View.VISIBLE
        placement_workplace_count.text = getString(R.string.placement_wp_number, list.count())
    }

    override fun showPlacementInfo(placement: Placement) {
        placement_height.text = getString(R.string.placement_height, placement.height)
        placement_space.text = getString(R.string.placement_space, placement.getSpace())
        placement_toolbar.text = getString(R.string.placement_number, placement.number)
    }
}