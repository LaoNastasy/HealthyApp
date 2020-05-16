package com.example.healthyapp.repo.implementations

import android.util.Log
import com.example.healthyapp.R
import com.example.healthyapp.db.model.entity.Placement
import com.example.healthyapp.db.model.entity.Workplace
import com.example.healthyapp.db.model.entity.WorkplaceUser
import com.example.healthyapp.repo.WorkplaceRepository
import com.google.firebase.firestore.FirebaseFirestore
import kotlin.math.roundToInt

class WorkplaceRepoImpl(private val db: FirebaseFirestore) : WorkplaceRepository {

    private var currentWorkplace: Workplace? = null
    private var currentUser: WorkplaceUser? = null

    override fun saveWorkplaceUserInformation(
        user: WorkplaceUser,
        placementId: String,
        onSuccess: (workplace: Workplace) -> Unit,
        onError: (Int) -> Unit
    ) {

        val table = user.height * 75 / 175

        val chair = table + user.shoulder - user.back

        val wp = Workplace(
            id = "",
            userId = user.id,
            tableHeight = table,
            chairHeight = chair,
            standHeight = chair - user.legsHeight,
            monitorHeight = chair + (user.sitHeight * 0.86F).roundToInt(),
            roomNumber = placementId
        )

        if (wp.tableHeight < 60
            || wp.tableHeight > 80
            || wp.chairHeight < 44
            || wp.chairHeight > 64
            || wp.standHeight < 0
            || wp.monitorHeight > 100
            || wp.monitorHeight < 30
        ) {
            onError(R.string.person_incorrect_data)
            return
        }
        currentWorkplace = wp
        currentUser = user

        onSuccess.invoke(wp)
    }

    override fun getCurrentWorkplace(
        onSuccess: (workplace: Workplace) -> Unit,
        onError: (Int) -> Unit
    ) {
        currentWorkplace ?: onError.invoke(R.string.common_error)
        onSuccess(currentWorkplace ?: return)
    }

    override fun saveWorkplace(
        onSuccess: () -> Unit,
        onError: (Int) -> Unit
    ) {

        currentUser ?: onError.invoke(R.string.common_error)
        val user = currentUser ?: return
        val wpUser = hashMapOf(
            "height" to user.height,
            "back" to user.back,
            "shoulder" to user.shoulder,
            "leg" to user.legsHeight,
            "sit_eyes_height" to user.eyesHeight,
            "name" to user.name
        )

        fun saveWP(id: String) {
            currentWorkplace ?: onError.invoke(R.string.common_error)
            val workplace = currentWorkplace ?: return
            val wp = hashMapOf(
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
                .addOnFailureListener { onError.invoke(R.string.common_error) }
        }

        db.collection("workplace_user")
            .add(wpUser)
            .addOnSuccessListener { saveWP(it.id) }
            .addOnFailureListener { onError.invoke(R.string.common_error) }

    }


    override fun saveRoom(
        placement: Placement,
        onSuccess: () -> Unit,
        onError: (Int) -> Unit
    ) {

        if (placement.height < 180
            || placement.length < 200
            || placement.width < 200
        ) {
            onError.invoke(R.string.room_error_validate)
            return
        }

        db.collection("placement")
            .whereEqualTo("number", placement.number)
            .addSnapshotListener { querySnapshot, firebaseFirestoreException ->
                if (firebaseFirestoreException != null) {
                    Log.w("FirebaseFS", firebaseFirestoreException.code.toString())
                    onError.invoke(R.string.common_error)
                    return@addSnapshotListener
                }

                if (querySnapshot?.documents?.size != 0) {
                    onError.invoke(R.string.room_number_exist)
                    return@addSnapshotListener
                }

                val pl = hashMapOf(
                    "number" to placement.number,
                    "length" to placement.length,
                    "width" to placement.width,
                    "height" to placement.height
                )

                db.collection("placement")
                    .add(pl)
                    .addOnSuccessListener { onSuccess.invoke() }
                    .addOnFailureListener { onError.invoke(R.string.common_error) }
            }


    }

    override fun getPlacements(
        onSuccess: (numbers: List<Placement>) -> Unit,
        onError: (Int) -> Unit
    ) {

        db.collection("placement")
            .get()
            .addOnSuccessListener {
                val numbers = arrayListOf<Placement>()
                for (document in it) {
                    numbers.add(
                        Placement(
                            document.id,
                            number = document["number"] as Long,
                            height = document["height"] as Long,
                            width = document["width"] as Long,
                            length = document["length"] as Long
                        )
                    )
                }
                onSuccess.invoke(numbers)
            }
            .addOnFailureListener { onError.invoke(R.string.common_error) }
    }

    override fun getWorkpacesByPlacement(
        placementId: String,
        onSuccess: (Int) -> Unit,
        onError: (Int) -> Unit
    ) {
        db.collection("workplace")
            .whereEqualTo("room_number", placementId)
            .get()
            .addOnSuccessListener {
                onSuccess.invoke(it.size())
            }
            .addOnFailureListener { onError.invoke(R.string.common_error) }
    }

}