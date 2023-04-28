package com.example.roomdatabasewithpaging3.Network

import com.example.paging3_mvvm.models.PassengersData
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    companion object {
        val BASE_URL: String = "https://api.instantwebtools.net/"
    }

    @GET("v1/passenger")
    suspend fun getPassengers(@Query("page") page: Int, @Query("size") size: Int = 10): PassengersData
}