package com.example.paging3_mvvm.models

import com.example.paging3_mvvm.models.Passenger

data class PassengersData(
    val data: List<Passenger>,
    val totalPages: Int,
    val totalPassengers: Int
)