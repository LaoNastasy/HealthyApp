package com.example.healthyapp.features.workplace

import com.example.healthyapp.base.BasePresenter
import com.example.healthyapp.base.BaseView
import com.example.healthyapp.db.model.entity.Workplace

interface WorkplaceListView : BaseView {
    fun showList(items: List<Workplace>)
}

class WorkplaceListPresenter : BasePresenter<WorkplaceListView>() {

    fun getList(){


    }

}