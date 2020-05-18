package com.example.healthyapp.features.information

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseFragment
import com.example.healthyapp.db.model.entity.Placement
import com.example.healthyapp.di.DI
import kotlinx.android.synthetic.main.fragment_info.view.*

class InfoFragment : BaseFragment<InfoPresenter, InfoView>(), InfoView {

    override fun initPresenter() = DI.component.infoPresenter()

    override fun getMvpView() = this

    private lateinit var adapter: PlacementAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_info, container, false)
        adapter = PlacementAdapter { goToPlacementInfo(it) }
        view.placement_list.layoutManager = LinearLayoutManager(requireContext())
        view.placement_list.adapter = adapter
        presenter.getPlacementList()

        return view
    }

    private fun goToPlacementInfo(placement: Placement) {
        val action = InfoFragmentDirections.actionInfoFragmentToPlacementInfoFragment(placement.id)
        findNavController().navigate(action)
    }

    override fun showPlacementList(list: List<Placement>) {
        adapter.setItems(list)
    }
}