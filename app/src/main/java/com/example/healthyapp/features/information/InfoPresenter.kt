package com.example.healthyapp.features.information

import com.example.healthyapp.base.BasePresenter
import com.example.healthyapp.base.BaseView
import com.example.healthyapp.db.model.entity.Placement
import com.example.healthyapp.repo.WorkplaceRepository

interface InfoView : BaseView {
    fun showPlacementList(list: List<Placement>)
}

class InfoPresenter(
    private val repo: WorkplaceRepository
) : BasePresenter<InfoView>() {

    fun getPlacementList() {
        repo.getPlacements(
            onSuccess = {
                view?.showPlacementList(it)
            },
            onError = { view?.showError(it) }
        )
    }
}