package com.example.healthyapp.repo

import com.example.healthyapp.db.model.entity.Placement
import com.example.healthyapp.db.model.entity.Workplace
import com.example.healthyapp.db.model.entity.WorkplaceUser

interface WorkplaceRepository {

    /**
     * сохранение информации о пользователе, для которого создается рабочее место
     * @param user - данные о пользователе
     * @param placementId -  помещение, выбранное для пользователя и рабочего места
     */
    fun saveWorkplaceUserInformation(
        user: WorkplaceUser,
        placementId: String,
        onSuccess: (workplace: Workplace) -> Unit,
        onError: (Int) -> Unit
    )

    /**
     * получение параметров текущего рабочего места
     */
    fun getCurrentWorkplace(
        onSuccess: (workplace: Workplace) -> Unit,
        onError: (Int) -> Unit
    )

    /**
     * сохранение рабочего места и пользователя в БД
     */
    fun saveWorkplace(
        onSuccess: () -> Unit,
        onError: (Int) -> Unit
    )

    /**
     * сохранение помещения в бд
     */

    fun saveRoom(
        placement: Placement,
        onSuccess: () -> Unit,
        onError: (Int) -> Unit
    )

    /**
     * получение всех помещений из бд
     */

    fun getPlacements(
        onSuccess: (placements: List<Placement>) -> Unit,
        onError: (Int) -> Unit
    )

    fun getPlacementById(
        id: String,
        onSuccess: (Placement) -> Unit,
        onError: (Int) -> Unit
    )

    /**
     * получение количества рабочих мест в рабочем помещении
     */
    fun getWorkplacesByPlacement(
        placementId: String,
        onSuccess: (List<Workplace>) -> Unit,
        onError: (Int) -> Unit
    )

}