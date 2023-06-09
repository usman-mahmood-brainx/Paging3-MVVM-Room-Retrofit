package com.example.paging3_mvvm.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "remoteKeys")
data class RemoteKeys(
    @PrimaryKey
    val _id:String,
    val prevKey:Int?,
    val nextKey:Int?
)