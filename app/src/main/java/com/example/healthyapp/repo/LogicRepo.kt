package com.example.healthyapp.repo

import com.example.healthyapp.db.model.entity.Placement
import com.example.healthyapp.db.model.entity.Workplace
import com.example.healthyapp.db.model.entity.WorkplaceUser

interface LogicRepo {

    fun addWorkplaceUserInformation(user: WorkplaceUser)
    fun getCurrentWorkplace(): Workplace?
    fun saveWorkplace(workplace: Workplace, onSuccess: () -> Unit)
    fun saveRoom(placement: Placement, onSuccess: () -> Unit)

}