package com.example.healthyapp.db.model.entity

data class Workplace(
    val id: String,
    val userId: String,
    val tableHeight: Long,
    val monitorHeight: Long,
    val chairHeight: Long,
    val standHeight: Long,
    val roomNumber: String
) {


    companion object {

        fun fromMap(id: String, data: Map<String, Any>): Workplace {
            return Workplace(
                id = id,
                userId = data["user_id"] as String,
                tableHeight = data["table"] as Long,
                standHeight = data["stand"] as Long,
                chairHeight = data["chair"] as Long,
                monitorHeight = data["monitor"] as Long,
                roomNumber = data["room_number"] as String
            )
        }
    }
}