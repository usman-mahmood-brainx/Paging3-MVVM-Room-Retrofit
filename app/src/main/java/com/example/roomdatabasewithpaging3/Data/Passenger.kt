package com.example.paging3_mvvm.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "passenger")
data class Passenger(
    @PrimaryKey
    val _id:String,
    val name: String,
    val trips: Int
)