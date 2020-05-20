package com.example.healthyapp.features.newWorkplace.roomNumber

import androidx.annotation.StringRes
import com.example.healthyapp.R
import com.example.healthyapp.base.BasePresenter
import com.example.healthyapp.base.BaseView
import com.example.healthyapp.db.model.entity.Placement
import com.example.healthyapp.repo.WorkplaceRepository

interface RoomNumberView : BaseView {
    fun showNumbers(list: List<Long>)
    fun showWarning(@StringRes res: Int)
    fun goNext(placementId: String)
    fun showLoading(show: Boolean)
}

class RoomNumberPresenter(private val repo: WorkplaceRepository) : BasePresenter<RoomNumberView>() {

    private var listPlacement = arrayListOf<Placement>()
    private var chosenPlacementId: String = ""

    fun getRoomNumbers() {
        view?.showLoading(true)
        repo.getPlacements(
            onSuccess = {
                view?.showLoading(false)
                listPlacement.clear()
                listPlacement.addAll(it)
                view?.showNumbers(it.map { it.number })
            },
            onError = {
                view?.showLoading(false)
                view?.showError(it)
            }
        )
    }

    fun addNewRoom() {

    }

    fun onItemSelected(position: Int) {
        val placement = listPlacement[position]
        chosenPlacementId = placement.id
        view?.showLoading(true)
        repo.getWorkplacesByPlacement(placement.id,
            onSuccess = {
                view?.showLoading(false)
                val count = it.count()
                val s = placement.length * placement.width
                val s1Now = s.toDouble() / count.toDouble()
                val s1After = s.toDouble() / (count + 1).toDouble()
                if (s1After > MIN_SPACE)
                    view?.goNext(placement.id)
                else {
                    if (s1Now > MIN_SPACE) view?.showWarning(R.string.room_warning)
                    else view?.showWarning(R.string.room_warning_important)
                }
            },
            onError = {
                view?.showLoading(false)
                view?.showError(it)
            })

    }

    fun onSubmitWarning() {
        view?.goNext(chosenPlacementId)
    }

    companion object {
        private const val MIN_SPACE = 45000
    }
}