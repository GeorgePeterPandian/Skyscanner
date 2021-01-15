package com.android.skyscanner.uk.flights.di

import com.android.skyscanner.core.architecture.ViewModelFactory
import com.android.skyscanner.skyscanner.domain.di.FlightsDomainComponent
import com.android.skyscanner.uk.flights.model.FlightsViewModel
import dagger.Component

@FlightsScope
@Component(dependencies = [FlightsDomainComponent::class])
interface FlightsUIComponent {
    fun getFlightsViewModelFactory(): ViewModelFactory<FlightsViewModel>
}