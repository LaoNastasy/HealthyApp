package com.example.healthyapp.db.model.entity

import java.math.BigDecimal

data class Placement(
    val id: String,
    val number: Long,
    val length: Long,
    val height: Long,
    val width: Long
) {
    fun getSpace(): String {
        val space = (this.width.toDouble() / 100) * ((this.length).toDouble() / 100)
        return BigDecimal.valueOf(space).setScale(2).toString()
    }
}