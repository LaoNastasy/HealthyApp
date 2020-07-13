package com.example.healthyapp.db.model.entity

data class User(
    val id: String,
    val login: String,
    val password: String,
    val firstName: String,
    val secondName: String
) {


    companion object {

        fun fromMap(id: String, map: Map<String, Any>): User {
            return User(
                id = id,
                login = map["login"] as String? ?: "",
                password = map["password"] as String? ?: "",
                firstName = map["firstName"] as String? ?: "",
                secondName = map["secondName"] as String? ?: ""
            )
        }

    }
}
