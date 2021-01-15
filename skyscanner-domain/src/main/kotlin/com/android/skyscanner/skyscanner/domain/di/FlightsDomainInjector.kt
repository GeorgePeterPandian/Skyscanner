package com.android.skyscanner.skyscanner.domain.di

import com.android.skyscanner.core.reactiveX.SchedulerProvider
import com.android.skyscanner.skyscanner.domain.FlightsRepository
import javax.inject.Provider

object FlightsDomainInjector {

    lateinit var component: FlightsDomainComponent

    fun initialise(repository: Provider<FlightsRepository>, schedulerProvider: SchedulerProvider) {
        component = DaggerFlightsDomainComponent.builder()
            .flightsDomainModule(FlightsDomainModule(repository, schedulerProvider))
            .build()
    }
}