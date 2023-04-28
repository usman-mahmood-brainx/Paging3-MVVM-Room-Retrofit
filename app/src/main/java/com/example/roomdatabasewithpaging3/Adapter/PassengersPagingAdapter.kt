package com.example.roomdatabasewithpaging3.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

import com.example.paging3_mvvm.models.Passenger
import com.example.roomdatabasewithpaging3.R
import javax.inject.Inject

class PassengersPagingAdapter @Inject constructor() : PagingDataAdapter<Passenger,PassengersPagingAdapter.ViewHolder>(
    DiffUtils) {

    object DiffUtils : DiffUtil.ItemCallback<Passenger>(){
        override fun areItemsTheSame(oldItem: Passenger, newItem: Passenger): Boolean {
            return oldItem._id == newItem._id
        }

        override fun areContentsTheSame(oldItem: Passenger, newItem: Passenger): Boolean {
            return oldItem == newItem
        }

    }

        // create new views
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            // inflates the card_view_design view
            // that is used to hold list item
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.passenger_item_layout, parent, false)

            return ViewHolder(view)
        }

        // binds the list items to a view
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            val passenger = getItem(position)

            holder.tvName.text = passenger?.name
            holder.tvTrips.text = passenger?.trips.toString()


        }

        // Holds the views for adding it to image and text
        class ViewHolder(passengerView: View) : RecyclerView.ViewHolder(passengerView) {
            val tvName: TextView = passengerView.findViewById(R.id.tvName)
            val tvTrips: TextView = passengerView.findViewById(R.id.tvTrips)

        }
    }