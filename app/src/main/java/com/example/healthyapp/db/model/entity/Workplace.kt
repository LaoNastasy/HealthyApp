package com.example.healthyapp.db.model.entity

data class Workplace(
    val id: String,
    val userId: String,
    val tableHeight: Int,
    val monitorHeight: Int,
    val chairHeight: Int,
    val standHeight: Int,
    val roomNumber: String
)