package com.android.skyscanner.uk.flights.list

import androidx.recyclerview.widget.RecyclerView
import com.android.skyscanner.image.loader.loadImage
import com.android.skyscanner.uk.databinding.ItineraryVhBinding
import com.android.skyscanner.uk.flights.model.FlightsUIM

internal class FlightsViewHolder(viewBinding: ItineraryVhBinding) :
    RecyclerView.ViewHolder(viewBinding.root) {

    private val layout = viewBinding

    fun onBind(flightsUIM: FlightsUIM) {
        with(layout) {
            uim = flightsUIM
            executePendingBindings()
        }
    }
}