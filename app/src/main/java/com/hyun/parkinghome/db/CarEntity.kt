package com.hyun.parkinghome.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CarEntity")
data class CarEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var addr: String = "", //집(501호 등)
    var number: String = "" //차량 번호판
)