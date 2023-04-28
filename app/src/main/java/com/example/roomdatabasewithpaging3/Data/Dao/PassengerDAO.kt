package com.example.paging3_mvvm.Room

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy
import com.example.paging3_mvvm.models.Passenger

@Dao
interface PassengerDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(passengers: List<Passenger>)

    @Query("Select * From passenger")
    fun getAllPassengers():PagingSource<Int,Passenger>

    @Query("Delete from passenger")
    fun clearAll()

}