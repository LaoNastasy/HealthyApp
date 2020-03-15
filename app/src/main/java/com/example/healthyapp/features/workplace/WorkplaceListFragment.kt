package com.example.healthyapp.features.workplace

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.healthyapp.R
import com.example.healthyapp.base.BaseFragment
import com.example.healthyapp.db.model.entity.Workplace
import com.example.healthyapp.di.DI
import kotlinx.android.synthetic.main.fragment_workplace_list.*

class WorkplaceListFragment : BaseFragment<WorkplaceListPresenter, WorkplaceListView>(),
    WorkplaceListView {

    override fun getMvpView() = this
    override fun initPresenter() = DI.component.worplaseListPresenter()

    private lateinit var adapter: WorkplaceListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_workplace_list, container, false)
        adapter = WorkplaceListAdapter()
        workplace_list.adapter = adapter
        presenter.getList()

        return view
    }

    override fun showList(items: List<Workplace>) {
        adapter.setItems(items)
    }

    override fun showError() {
        showError(getString(R.string.common_error))
    }


}