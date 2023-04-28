package com.example.roomdatabasewithpaging3.Data.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.paging3_mvvm.Room.PassengerDAO
import com.example.paging3_mvvm.Room.RemoteKeysDao
import com.example.paging3_mvvm.models.Passenger
import com.example.paging3_mvvm.models.RemoteKeys

@Database(entities = [Passenger::class,RemoteKeys::class],version = 1,exportSchema = false)
abstract class Database : RoomDatabase(){

    abstract fun getPassengerDao(): PassengerDAO
    abstract fun remoteKeyDao():RemoteKeysDao
}