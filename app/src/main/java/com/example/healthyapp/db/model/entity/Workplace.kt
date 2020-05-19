package com.example.healthyapp.db.model.entity

data class Workplace(
    val id: String,
    val userId: String,
    val tableHeight: Long,
    val monitorHeight: Long,
    val chairHeight: Long,
    val standHeight: Long,
    val roomNumber: String
)