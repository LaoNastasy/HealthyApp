package com.example.healthyapp.repo.implementations

import com.example.healthyapp.db.model.entity.Placement
import com.example.healthyapp.db.model.entity.Workplace
import com.example.healthyapp.db.model.entity.WorkplaceUser
import com.example.healthyapp.repo.WorkplaceRepo
import com.google.firebase.firestore.FirebaseFirestore
import kotlin.math.roundToInt

class WorkplaceRepoImpl(private val db: FirebaseFirestore) : WorkplaceRepo {

    private var currentWorkplace: Workplace? = null
    private var currentUser: WorkplaceUser? = null

    override fun saveWorkplaceUserInformation(
        user: WorkplaceUser,
        roomNumber: Int,
        onSuccess: (workplace: Workplace) -> Unit,
        onError: () -> Unit
    ) {

        val table = user.height * 75 / 175
        val chair = table + user.shoulder - user.back

        val wp = Workplace(
            id = 0,
            userId = user.id,
            tableHeight = table,
            chairHeight = chair,
            standHeight = chair - user.legsHeight,
            monitorHeight = chair + (user.height * 0.86F).roundToInt(),
            roomNumber = roomNumber
        )
        currentWorkplace = wp
        currentUser = user

        onSuccess.invoke(wp)
    }

    override fun getCurrentWorkplace(
        onSuccess: (workplace: Workplace) -> Unit,
        onError: () -> Unit
    ) {
        currentWorkplace ?: onError.invoke()
        onSuccess(currentWorkplace ?: return)
    }

    override fun saveWorkplace(
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        currentUser ?: onError.invoke()
        val user = currentUser ?: return
        val wpUser = hashSetOf(
            "height" to user.height,
            "back" to user.back,
            "shoulder" to user.shoulder,
            "leg" to user.legsHeight,
            "sit_eyes_height" to user.eyesHeight,
            "name" to user.name
        )

        fun saveWP(id: String) {
            currentWorkplace ?: onError.invoke()
            val workplace = currentWorkplace ?: return
            val wp = hashSetOf(
                "user_id" to "workplace_user/$id",
                "table" to workplace.tableHeight,
                "chair" to workplace.chairHeight,
                "stand" to workplace.standHeight,
                "monitor" to workplace.monitorHeight,
                "room_number" to workplace.roomNumber
            )

            db.collection("workplace")
                .add(wp)
                .addOnSuccessListener { onSuccess.invoke() }
                .addOnFailureListener { onError.invoke() }
        }

        db.collection("workplace_user")
            .add(wpUser)
            .addOnSuccessListener { saveWP(it.id) }
            .addOnFailureListener { onError.invoke() }

    }


    override fun saveRoom(placement: Placement, onSuccess: () -> Unit) {


//        CoroutineScope(Dispatchers.IO).launch {
//            db.getPlacementDao().addPlacement(placement)
//            withContext(Dispatchers.Main) { onSuccess.invoke() }
//        }
    }

}