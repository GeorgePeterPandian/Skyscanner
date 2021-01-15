package com.android.skyscanner.uk.flights.list

import androidx.recyclerview.widget.DiffUtil
import com.android.skyscanner.uk.flights.model.FlightsUIM

internal class FlightsDiffCallback : DiffUtil.ItemCallback<FlightsUIM>() {

    override fun areItemsTheSame(oldItem: FlightsUIM, newItem: FlightsUIM) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: FlightsUIM, newItem: FlightsUIM) = oldItem == newItem
}