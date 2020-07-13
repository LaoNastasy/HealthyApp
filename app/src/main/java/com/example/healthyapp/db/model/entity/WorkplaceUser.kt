package com.example.healthyapp.db.model.entity

data class WorkplaceUser(
    val id: String,
    val height: Long,
    val sitHeight: Long,
    val legsHeight: Long,
    val eyesHeight: Long,
    val shoulder: Long,
    val back: Long,
    val name: String
) {

    companion object {

        fun fromMap(id: String, map: Map<String, Any>): WorkplaceUser {
            return WorkplaceUser(
                id = id,
                height = map["height"] as Long,
                sitHeight = map["sit_eyes_height"] as Long,
                legsHeight = map["leg"] as Long,
                eyesHeight = map["sit_eyes_height"] as Long,
                shoulder = map["shoulder"] as Long,
                back = map["back"] as Long,
                name = map["name"] as String
            )
        }
    }
}