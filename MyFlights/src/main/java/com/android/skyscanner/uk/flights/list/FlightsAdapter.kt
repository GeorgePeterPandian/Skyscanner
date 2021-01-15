package com.android.skyscanner.uk.flights.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.android.skyscanner.uk.databinding.ItineraryVhBinding
import com.android.skyscanner.uk.flights.model.FlightsUIM

internal class FlightsAdapter : ListAdapter<FlightsUIM, FlightsViewHolder>(FlightsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FlightsViewHolder(
            ItineraryVhBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: FlightsViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}