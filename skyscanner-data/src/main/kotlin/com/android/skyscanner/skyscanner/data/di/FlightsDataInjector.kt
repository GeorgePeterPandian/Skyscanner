package com.android.skyscanner.skyscanner.data.di

import android.content.Context
import com.android.skyscanner.skyscanner.domain.di.FlightsDomainInjector

object FlightsDataInjector {

    private lateinit var component: FlightsDataComponent

    fun initialise(context: Context) {
        component =
            DaggerFlightsDataComponent.builder()
                .flightsDataModule(FlightsDataModule()).build()
        with(component) {
            FlightsDomainInjector.initialise(getFlightsRepository(), getSchedulerProvider())
        }
    }
}