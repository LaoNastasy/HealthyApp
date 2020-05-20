package com.example.healthyapp.features.information.placementInfo

import com.example.healthyapp.base.BasePresenter
import com.example.healthyapp.base.BaseView
import com.example.healthyapp.db.model.entity.Placement
import com.example.healthyapp.db.model.entity.Workplace
import com.example.healthyapp.repo.WorkplaceRepository

interface PlacementInfoView : BaseView {
    fun showWorkplaces(list: List<Workplace>)
    fun showPlacementInfo(placement: Placement)
    fun showWarning(number: Long)
}

class PlacementInfoPresenter(
    private val repo: WorkplaceRepository
) : BasePresenter<PlacementInfoView>() {

    private lateinit var placement: Placement
    private val MIN_SPACE = 45000

    fun getPlacementInfo(placementId: String) {
        repo.getPlacementById(
            placementId,
            onSuccess = {
                placement = it
                view?.showPlacementInfo(it)
                getWorkplaces(placementId)
            },
            onError = { view?.showError(it) }
        )
    }

    private fun getWorkplaces(placementId: String) {
        repo.getWorkplacesByPlacement(
            placementId,
            onSuccess = {
                view?.showWorkplaces(it)

                val count = it.count()
                val s = placement.length * placement.width
                val s1 = s.toDouble() / count.toDouble()

                if (s1 > MIN_SPACE) return@getWorkplacesByPlacement
                else {
                    val n = count - s / MIN_SPACE
                    view?.showWarning(n)
                }
            },
            onError =
            { view?.showError(it) })
    }


}