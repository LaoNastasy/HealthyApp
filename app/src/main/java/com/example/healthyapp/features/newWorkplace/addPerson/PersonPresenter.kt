package com.example.healthyapp.features.newWorkplace.addPerson

import androidx.annotation.StringRes
import com.example.healthyapp.base.BasePresenter
import com.example.healthyapp.base.BaseView
import com.example.healthyapp.db.model.entity.WorkplaceUser
import com.example.healthyapp.repo.WorkplaceRepository
import javax.inject.Inject

interface PersonView : BaseView {
    fun goBack()
    fun showWorkplace()
    fun showErrorAlert(@StringRes message: Int)
}

class PersonPresenter @Inject constructor(private val workplaceRepo: WorkplaceRepository) :
    BasePresenter<PersonView>() {

    fun onBackClick() {
        view?.goBack()
    }

    fun onSaveClick(
        height: String,
        sitHeight: String,
        backHeight: String,
        legsHeight: String,
        shoulderHeight: String,
        name: String,
        placementId: String
    ) {
        val heightInt = height.toLong()
        val sitHeightInt = sitHeight.toLong()
        val backHeightInt = backHeight.toLong()
        val legsHeightInt = legsHeight.toLong()
        val shoulderHeightInt = shoulderHeight.toLong()

        if (heightInt <= 0
            || backHeightInt <= 0
            || legsHeightInt <= 0
            || shoulderHeightInt <= 0
            || sitHeightInt <= 0) {
            view?.showError()
            return
        }
        workplaceRepo.saveWorkplaceUserInformation(
            WorkplaceUser(
                id = "",
                height = heightInt,
                sitHeight = sitHeightInt,
                eyesHeight = backHeightInt,
                legsHeight = legsHeightInt,
                shoulder = shoulderHeightInt,
                back = backHeightInt,
                name = name
            ),
            placementId
            , onSuccess = { view?.showWorkplace() },
            onError = { view?.showErrorAlert(it) }
        )

    }

}