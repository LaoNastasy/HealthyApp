package com.example.healthyapp.features.roomEdit

import com.example.healthyapp.base.BasePresenter
import com.example.healthyapp.base.BaseView
import com.example.healthyapp.db.model.entity.Placement
import com.example.healthyapp.repo.LogicRepo

interface RoomEditView : BaseView {
    fun showAddWorkplaceDialog()
}

class RoomEditPresenter(private val logicRepo: LogicRepo) : BasePresenter<RoomEditView>() {

    private var currentRoom: Placement? = null

    fun saveRoom(placement: Placement) {
        logicRepo.saveRoom(placement) {
            currentRoom = placement
            view?.showAddWorkplaceDialog()
        }
    }

    fun getRoomNumber() = currentRoom?.number
}