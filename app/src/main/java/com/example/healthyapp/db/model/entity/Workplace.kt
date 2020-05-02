package com.example.healthyapp.db.model.entity

data class Workplace(
    val id: Long,
    val userId: Long,
    val tableHeight: Int,
    val monitorHeight: Int,
    val chairHeight: Int,
    val standHeight: Int,
    val roomNumber: Int
)