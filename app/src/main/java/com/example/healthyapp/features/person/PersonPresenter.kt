package com.example.healthyapp.features.person

import com.example.healthyapp.base.BasePresenter
import com.example.healthyapp.base.BaseView
import com.example.healthyapp.db.model.entity.WorkplaceUser
import com.example.healthyapp.repo.LogicRepo
import javax.inject.Inject

interface PersonView : BaseView {
    fun goBack()
    fun showWorkplace()
}

class PersonPresenter @Inject constructor(private val logicRepo: LogicRepo) :
    BasePresenter<PersonView>() {

    fun onBackClick() {
        view?.goBack()
    }

    fun onSaveClick(
        height: String,
        backHeight: String,
        legsHeight: String,
        shoulderHeight: String,
        roomNumber:Int
    ) {
        val heightInt = height.toInt()
        val backHeightInt = backHeight.toInt()
        val legsHeightInt = legsHeight.toInt()
        val shoulderHeightInt = shoulderHeight.toInt()

        if (heightInt <= 0 || backHeightInt <= 0 || legsHeightInt <= 0 || shoulderHeightInt <= 0) {
            view?.showError()
            return
        }
        logicRepo.addWorkplaceUserInformation(
            WorkplaceUser(
                id = 0,
                userHeight = heightInt,
                backHeight = backHeightInt,
                userLegsHeight = legsHeightInt,
                shoulderHeight = shoulderHeightInt
            ), roomNumber
        )

        view?.showWorkplace()
    }

}