package com.example.healthyapp.features.roomEdit

import com.example.healthyapp.base.BasePresenter
import com.example.healthyapp.base.BaseView
import com.example.healthyapp.db.model.entity.Placement
import com.example.healthyapp.repo.WorkplaceRepo

interface RoomEditView : BaseView {
    fun showAddWorkplaceDialog()
}

class RoomEditPresenter(private val workplaceRepo: WorkplaceRepo) : BasePresenter<RoomEditView>() {

    private var currentRoom: Placement? = null

    fun saveRoom(placement: Placement) {
        workplaceRepo.saveRoom(
            placement,
            onSuccess = {
                currentRoom = placement
                view?.showAddWorkplaceDialog()
            },
            onError = {
                view?.showError()
            }
        )
    }

    fun getRoomNumber() = currentRoom?.number
}