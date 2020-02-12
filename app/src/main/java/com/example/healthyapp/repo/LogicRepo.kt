package com.example.healthyapp.repo

import com.example.healthyapp.db.model.entity.Workplace
import com.example.healthyapp.db.model.entity.WorkplaceUser

interface LogicRepo {

    fun getWorkplaceInformation(user: WorkplaceUser): Workplace

}