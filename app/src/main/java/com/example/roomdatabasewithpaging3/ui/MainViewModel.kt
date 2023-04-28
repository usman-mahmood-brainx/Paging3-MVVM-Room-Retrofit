package com.example.roomdatabasewithpaging3.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.example.paging3_mvvm.models.Passenger
import com.example.roomdatabasewithpaging3.Data.Database.Database
import com.example.roomdatabasewithpaging3.Data.Repository.PassengersRemoteMediator
import com.example.roomdatabasewithpaging3.Network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel  @Inject constructor(private val db:Database,private val apiService: ApiService) : ViewModel() {

    @ExperimentalPagingApi
    fun getAllPassengers() : Flow<PagingData<Passenger>> = Pager(
        config = PagingConfig(100,enablePlaceholders = false),
        pagingSourceFactory = {db.getPassengerDao().getAllPassengers()},
        remoteMediator = PassengersRemoteMediator(db,apiService)
    ).flow.cachedIn(viewModelScope)
}