package com.android.skyscanner.uk.flights.di

import com.android.skyscanner.skyscanner.domain.di.FlightsDomainInjector


object FlightsUIInjector {

    lateinit var component: FlightsUIComponent

    fun initialise() {
        component =
            DaggerFlightsUIComponent.builder()
                .flightsDomainComponent(FlightsDomainInjector.component)
                .build()
    }
}
