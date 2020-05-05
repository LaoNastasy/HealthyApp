package com.example.healthyapp.features.person

import com.example.healthyapp.base.BasePresenter
import com.example.healthyapp.base.BaseView
import com.example.healthyapp.repo.WorkplaceRepo

interface RoomNumberView : BaseView {
    fun showNumbers(list: List<Long>)
}

class RoomNumberPresenter(private val repo: WorkplaceRepo) : BasePresenter<RoomNumberView>() {

    fun getRoomNumbers() {
        repo.getPlacements(
            onSuccess = {
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

    }
}