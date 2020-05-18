package com.example.healthyapp.features.roomEdit

import com.example.healthyapp.base.BasePresenter
import com.example.healthyapp.base.BaseView
import com.example.healthyapp.db.model.entity.Placement
import com.example.healthyapp.repo.WorkplaceRepository

interface NewPlacementView : BaseView {
    fun showAddWorkplaceDialog()
}

class NewPlacementPresenter(
    private val workplaceRepo: WorkplaceRepository
) : BasePresenter<NewPlacementView>() {

    private var currentRoom: Placement? = null

    fun saveRoom(placement: Placement) {
        workplaceRepo.saveRoom(
            placement,
            onSuccess = {
                currentRoom = placement
                view?.showAddWorkplaceDialog()
            },
            onError = {
                view?.showError(it)
            }
        )
    }

    fun getPlacementId() = currentRoom?.id ?: ""
}