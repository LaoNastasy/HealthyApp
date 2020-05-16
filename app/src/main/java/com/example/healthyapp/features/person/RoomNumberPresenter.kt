package com.example.healthyapp.features.person

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
}

class RoomNumberPresenter(private val repo: WorkplaceRepository) : BasePresenter<RoomNumberView>() {

    private var listPlacement = arrayListOf<Placement>()
    private var chosenPlacementId: String = ""

    fun getRoomNumbers() {
        repo.getPlacements(
            onSuccess = {
                listPlacement.clear()
                listPlacement.addAll(it)
                view?.showNumbers(it.map { it.number })
            },
            onError = {
                view?.showError(it)
            }
        )
    }

    fun addNewRoom() {

    }

    fun onItemSelected(position: Int) {
        val placement = listPlacement[position]
        chosenPlacementId = placement.id
        repo.getWorkplacesByPlacement(placement.id,
            onSuccess = {
                val s = placement.length * placement.width
                val s1Now = s.toDouble() / it.toDouble()
                val s1After = s.toDouble() / (it + 1).toDouble()
                if (s1After > 4500)
                    view?.goNext(placement.id)
                else {
                    if (s1Now > 4500) view?.showWarning(R.string.room_warning)
                    else view?.showWarning(R.string.room_warning_important)
                }
            },
            onError = { view?.showError(it) })

    }

    fun onSubmitWarning() {
        view?.goNext(chosenPlacementId)
    }
}