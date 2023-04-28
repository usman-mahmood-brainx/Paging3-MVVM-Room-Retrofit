package com.example.roomdatabasewithpaging3.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.ExperimentalPagingApi
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdatabasewithpaging3.Adapter.PassengersPagingAdapter
import com.example.roomdatabasewithpaging3.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel:MainViewModel  by viewModels()
    @Inject
    lateinit var passengerAdapter: PassengersPagingAdapter
    @ExperimentalPagingApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intiRecyclerView()

        lifecycleScope.launchWhenStarted {
            mainViewModel.getAllPassengers().collectLatest { response->
                Log.d("main", "onCreate: $response")
                passengerAdapter.submitData(response)
            }
        }

    }
    private fun intiRecyclerView() {
        binding.apply {
            rvPessengers.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = passengerAdapter
            }
        }
    }
}