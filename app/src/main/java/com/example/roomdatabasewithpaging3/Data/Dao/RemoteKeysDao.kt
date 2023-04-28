package com.example.paging3_mvvm.Room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.paging3_mvvm.models.Passenger
import com.example.paging3_mvvm.models.RemoteKeys

@Dao
interface RemoteKeysDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(passengers:List<RemoteKeys>)

    @Query("Select * From remoteKeys Where _id =:id")
    fun getAllRemoteKeys(id:String):RemoteKeys

    @Query("DELETE FROM remoteKeys")
    fun clearAll()
}
