package com.android.skyscanner.skyscanner.domain.di

import com.android.skyscanner.skyscanner.domain.usecases.LoadFlightsUseCase
import dagger.Component

@Component(modules = [FlightsDomainModule::class])
interface FlightsDomainComponent {
    fun getLoadFlightsUseCase(): LoadFlightsUseCase
}