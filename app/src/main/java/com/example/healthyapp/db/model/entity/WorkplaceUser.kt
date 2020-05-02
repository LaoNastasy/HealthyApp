package com.example.healthyapp.db.model.entity

data class WorkplaceUser(
    val id: Long,
    val height: Int,
    val legsHeight: Int,
    val eyesHeight: Int,
    val shoulder: Int,
    val back: Int,
    val name: String
)