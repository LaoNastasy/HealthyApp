package com.example.healthyapp.db.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reference_indicators")
data class ReferenceIndicators(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    @ColumnInfo(name = "id_placement") var idPlacement: Long,
    @ColumnInfo(name = "reference_humidity") var referenceHumidity: Int,
    @ColumnInfo(name = "reference_temperature") var referenceTemperature: Int,
    @ColumnInfo(name = "reference_illumination") var referenceIllumination: Int
)