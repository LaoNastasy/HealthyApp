package com.example.healthyapp.repo.implementations

import com.example.healthyapp.db.model.entity.Workplace
import com.example.healthyapp.db.model.entity.WorkplaceUser
import com.example.healthyapp.repo.LogicRepo
import kotlin.math.roundToInt

class LogicRepoImpl : LogicRepo {

    private var currentWorkplace: Workplace? = null

    override fun addWorkplaceUserInformation(user: WorkplaceUser) {

        val table = 70
        val chair = table + user.shoulderHeight - user.backHeight

        currentWorkplace = Workplace(
            id = 0,
            userId = user.id,
            tableHeight = table,
            keyboardHeight = table,
            chairHeight = chair,
            standHeight = chair - user.userLegsHeight,
            monitorHeight = chair + (user.userHeight * 0.86F).roundToInt()
        )
    }

    override fun getCurrentWorkplace(): Workplace? = currentWorkplace

}