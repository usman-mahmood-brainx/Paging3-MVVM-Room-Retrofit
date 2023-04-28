package com.example.paging3_mvvm.models

data class PassengersData(
    val data: List<Passenger>,
    val totalPages: Int,
    val totalPassengers: Int
)