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
)