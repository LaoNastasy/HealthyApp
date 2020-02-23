package com.example.healthyapp.features.roomEdit

import com.example.healthyapp.base.BasePresenter
import com.example.healthyapp.base.BaseView
import com.example.healthyapp.db.model.entity.Placement
import com.example.healthyapp.repo.LogicRepo

interface RoomEditView : BaseView {
    fun showAddWorkplaceDialog()
}

class RoomEditPresenter(private val logicRepo: LogicRepo) : BasePresenter<RoomEditView>() {

    fun saveRoom(placement: Placement) {
        logicRepo.saveRoom(placement) {
            view?.showAddWorkplaceDialog()
        }
    }
}