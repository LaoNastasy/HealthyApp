package com.example.healthyapp.features.information.workplaceInfo

import com.example.healthyapp.base.BasePresenter
import com.example.healthyapp.base.BaseView
import com.example.healthyapp.db.model.entity.Workplace
import com.example.healthyapp.db.model.entity.WorkplaceUser
import com.example.healthyapp.repo.WorkplaceRepository

interface WorkplaceInfoView : BaseView {
    fun showWorkplaceInfo(workplace: Workplace)
    fun showUserInfo(workplaceUser: WorkplaceUser)
}

class WorkplaceInfoPresenter(
    private val repo: WorkplaceRepository
) : BasePresenter<WorkplaceInfoView>() {

    fun getWorkplaceInfo(workplaceId: String) {
        repo.getWorkplaceById(
            workplaceId,
            onSuccess = {
                view?.showWorkplaceInfo(it)
                repo.getWorkplaceUserById(
                    it.userId,
                    onSuccess = {
                        view?.showUserInfo(it)
                    },
                    onError = {
                        view?.showError(it)
                    })
            },
            onError = {
                view?.showError(it)
            }
        )
    }

}