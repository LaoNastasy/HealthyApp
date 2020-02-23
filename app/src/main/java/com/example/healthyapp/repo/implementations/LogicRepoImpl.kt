package com.example.healthyapp.repo.implementations

import com.example.healthyapp.db.Database
import com.example.healthyapp.db.model.entity.Placement
import com.example.healthyapp.db.model.entity.Workplace
import com.example.healthyapp.db.model.entity.WorkplaceUser
import com.example.healthyapp.repo.LogicRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.math.roundToInt

class LogicRepoImpl(private val db: Database) : LogicRepo {

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

    override fun saveWorkplace(workplace: Workplace, onSuccess: () -> Unit) {

        CoroutineScope(Dispatchers.IO).launch {
            db.getWorkplaceDao().addWorkplace(workplace)
            withContext(Dispatchers.Main) { onSuccess.invoke() }
        }

    }

    override fun saveRoom(placement: Placement, onSuccess: () -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            db.getPlacementDao().addPlacement(placement)
            withContext(Dispatchers.Main) { onSuccess.invoke() }
        }
    }

}