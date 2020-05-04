package com.example.healthyapp.repo

import com.example.healthyapp.db.model.entity.Placement
import com.example.healthyapp.db.model.entity.Workplace
import com.example.healthyapp.db.model.entity.WorkplaceUser

interface WorkplaceRepo {

    /**
     * сохранение информации о пользователе, для которого создается рабочее место
     *
     * @param user - данные о пользователе
     * @param roomNumber -  помещение, выбранное для пользователя и рабочего места
     */
    fun saveWorkplaceUserInformation(
        user: WorkplaceUser,
        roomNumber: Int,
        onSuccess: (workplace: Workplace) -> Unit,
        onError: () -> Unit
    )

    /**
     * получение параметров текущего рабочего места
     */
    fun getCurrentWorkplace(
        onSuccess: (workplace: Workplace) -> Unit,
        onError: () -> Unit
    )

    /**
     * сохранение рабочего места и пользователя в БД
     */
    fun saveWorkplace(
        onSuccess: () -> Unit,
        onError: () -> Unit
    )

    /**
     * сохранение помещения в бд
     */

    fun saveRoom(
        placement: Placement,
        onSuccess: () -> Unit,
        onError: () -> Unit
    )

}