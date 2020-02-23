package com.example.healthyapp.features.person

import com.example.healthyapp.base.BasePresenter
import com.example.healthyapp.base.BaseView
import com.example.healthyapp.db.model.entity.Workplace
import com.example.healthyapp.repo.LogicRepo
import javax.inject.Inject

interface WorkplaceView : BaseView {

    fun showWorkplace(workplace: Workplace)
    fun close()
}

class WorkplacePresenter @Inject constructor(private val logicRepo: LogicRepo) :
    BasePresenter<WorkplaceView>() {

    private var currentWorkplace: Workplace? = null

    fun getCurrentWorkplace() {
        val place = logicRepo.getCurrentWorkplace()
        if (place == null) view?.showError()
        else view?.showWorkplace(place)
    }

    fun saveWorkplace() {
        logicRepo.saveWorkplace(currentWorkplace ?: return) {
            view?.close()
        }
    }
}