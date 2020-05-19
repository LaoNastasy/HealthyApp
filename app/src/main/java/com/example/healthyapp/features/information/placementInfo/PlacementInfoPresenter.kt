package com.example.healthyapp.features.information.placementInfo

import com.example.healthyapp.base.BasePresenter
import com.example.healthyapp.base.BaseView
import com.example.healthyapp.db.model.entity.Placement
import com.example.healthyapp.db.model.entity.Workplace
import com.example.healthyapp.repo.WorkplaceRepository

interface PlacementInfoView : BaseView {
    fun showWorkplaces(list: List<Workplace>)
    fun showPlacementInfo(placement: Placement)
}

class PlacementInfoPresenter(
    private val repo: WorkplaceRepository
) : BasePresenter<PlacementInfoView>() {

    fun getPlacementInfo(placementId: String) {
        repo.getPlacementById(
            placementId,
            onSuccess = {
                view?.showPlacementInfo(it)
            },
            onError = { view?.showError(it) }
        )
    }

    fun getWorkplaces(placementId: String) {
        repo.getWorkplacesByPlacement(placementId,
            onSuccess = {
                view?.showWorkplaces(it)
            },
            onError = { view?.showError(it) })
    }


}