package com.example.healthyapp.features.person

import com.example.healthyapp.base.BasePresenter
import com.example.healthyapp.base.BaseView
import com.example.healthyapp.db.model.entity.Workplace
import com.example.healthyapp.repo.WorkplaceRepository
import javax.inject.Inject

interface WorkplaceView : BaseView {

    fun showWorkplace(workplace: Workplace)
    fun showSuccessSaveDialog()
}

class WorkplacePresenter @Inject constructor(private val workplaceRepo: WorkplaceRepository) :
    BasePresenter<WorkplaceView>() {

    fun getCurrentWorkplace() {
        workplaceRepo.getCurrentWorkplace(
            onSuccess = { view?.showWorkplace(it) },
            onError = { view?.showError() }
        )
    }

    fun saveWorkplace() {
        workplaceRepo.saveWorkplace(
            onSuccess = { view?.showSuccessSaveDialog() },
            onError = { view?.showError() }
        )
    }
}