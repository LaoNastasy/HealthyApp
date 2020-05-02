package com.example.healthyapp.db.model.entity

data class User(
    val id: String,
    val login: String,
    val password: String,
    val firstName: String,
    val secondName: String
)