package com.example.healthyapp.features.information.placementInfo

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseFragment
import com.example.healthyapp.db.model.entity.Placement
import com.example.healthyapp.db.model.entity.Workplace
import com.example.healthyapp.di.DI
import kotlinx.android.synthetic.main.fragment_placement_info.*

class PlacementInfoFragment :
    BaseFragment<PlacementInfoPresenter, PlacementInfoView>(R.layout.fragment_placement_info),
    PlacementInfoView {

    override fun getMvpView() = this

    override fun initPresenter() = DI.component.placementInfoPresenter()

    private lateinit var adapter: WorkplaceAdapter
    private lateinit var placementId: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        placementId = arguments?.getString("placementId") ?: ""
        adapter =
            WorkplaceAdapter {
                val action =
                    PlacementInfoFragmentDirections.actionPlacementInfoFragmentToWorkplaceInfoFragment(
                        it.id
                    )
                findNavController().navigate(action)
            }
        back.setOnClickListener { findNavController().popBackStack() }

        placement_workplace_list.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapter
        }
        presenter.getPlacementInfo(placementId)
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

    override fun showWarning(number: Long) {
        placement_warning.text = getString(R.string.placement_warn, number)
        placement_warning.visibility = View.VISIBLE
    }
}