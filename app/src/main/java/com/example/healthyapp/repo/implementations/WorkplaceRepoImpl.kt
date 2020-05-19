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
            standHeight = (chair - user.legsHeight),
            monitorHeight = (chair + (user.sitHeight * COEFFICIENT).roundToInt() - table),
            roomNumber = placementId
        )

        if (wp.tableHeight < MIN_TABLE_HEIGHT
            || wp.tableHeight > MAX_TABLE_HEIGHT
            || wp.chairHeight < MIN_CHAIR_HEIGHT
            || wp.chairHeight > MAX_CHAIR_HEIGHT
            || wp.standHeight < MIN_STAND_HEIGHT
            || wp.monitorHeight > MAX_MONITOR_HEIGHT
            || wp.monitorHeight < MIN_MONITOR_HEIGHT
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


    override fun getWorkplaceById(
        id: String,
        onSuccess: (Workplace) -> Unit,
        onError: (Int) -> Unit
    ) {
        db.document("/workplace/$id")
            .get()
            .addOnSuccessListener {
                val document = it.data
                if (document == null) onError.invoke(R.string.common_error)
                else {
                    val wp = Workplace(
                        id = it.id,
                        userId = document["user_id"] as String,
                        tableHeight = document["table"] as Long,
                        standHeight = document["stand"] as Long,
                        chairHeight = document["chair"] as Long,
                        monitorHeight = document["monitor"] as Long,
                        roomNumber = document["room_number"] as String
                    )
                    onSuccess.invoke(wp)
                }
            }
            .addOnFailureListener {
                onError.invoke(R.string.common_error)
            }
    }

    override fun getWorkplaceUserById(
        id: String,
        onSuccess: (WorkplaceUser) -> Unit,
        onError: (Int) -> Unit
    ) {
        db.document("/workplace_user/$id")
            .get()
            .addOnSuccessListener {
                val document = it.data
                if (document == null) onError.invoke(R.string.common_error)
                else {
                    val wp = WorkplaceUser(
                        id = it.id,
                        height = document["height"] as Long,
                        sitHeight = document["sit_height"] as Long,
                        legsHeight = document["leg"] as Long,
                        eyesHeight = document["sit_eyes_height"] as Long,
                        shoulder = document["shoulder"] as Long,
                        back = document["back"] as Long,
                        name = document["name"] as String
                    )
                    onSuccess.invoke(wp)
                }
            }
            .addOnFailureListener {
                onError.invoke(R.string.common_error)
            }
    }

    override fun saveRoom(
        placement: Placement,
        onSuccess: () -> Unit,
        onError: (Int) -> Unit
    ) {

        if (placement.height < MIN_ROOM_HEIGHT
            || placement.length < MIN_ROOM_LENGTH
            || placement.width < MIN_ROOM_WIDTH
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

    override fun getPlacementById(
        id: String,
        onSuccess: (Placement) -> Unit,
        onError: (Int) -> Unit
    ) {
        db.document("/placement/$id")
            .get()
            .addOnSuccessListener {
                val data = it.data
                if (data == null) onError.invoke(R.string.common_error)
                else {
                    onSuccess.invoke(
                        Placement(
                            id = it.id,
                            height = data["height"] as Long,
                            width = data["width"] as Long,
                            number = data["number"] as Long,
                            length = data["length"] as Long
                        )
                    )
                }
            }
            .addOnFailureListener {
                onError.invoke(R.string.common_error)
            }
    }

    override fun getWorkplacesByPlacement(
        placementId: String,
        onSuccess: (List<Workplace>) -> Unit,
        onError: (Int) -> Unit
    ) {


        db.collection("workplace")
            .whereEqualTo("room_number", placementId)
            .get()
            .addOnSuccessListener {
                val workplaces = arrayListOf<Workplace>()
                for (document in it.documents) {

                    workplaces.add(
                        Workplace(
                            id = document.id,
                            userId = document["user_id"] as String,
                            tableHeight = document["table"] as Long,
                            standHeight = document["stand"] as Long,
                            chairHeight = document["chair"] as Long,
                            monitorHeight = document["monitor"] as Long,
                            roomNumber = document["room_number"] as String
                        )
                    )

                }
                onSuccess.invoke(workplaces)
            }
            .addOnFailureListener { onError.invoke(R.string.common_error) }
    }


    companion object {
        private const val MIN_TABLE_HEIGHT = 60
        private const val MAX_TABLE_HEIGHT = 80
        private const val MIN_CHAIR_HEIGHT = 44
        private const val MAX_CHAIR_HEIGHT = 64
        private const val MIN_STAND_HEIGHT = 0
        private const val MIN_MONITOR_HEIGHT = 30
        private const val MAX_MONITOR_HEIGHT = 100

        private const val COEFFICIENT = 0.86F

        private const val MIN_ROOM_HEIGHT = 270
        private const val MIN_ROOM_WIDTH = 200
        private const val MIN_ROOM_LENGTH = 200

    }
}