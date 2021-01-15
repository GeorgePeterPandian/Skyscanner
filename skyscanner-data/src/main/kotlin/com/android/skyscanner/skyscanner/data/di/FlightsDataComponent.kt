package com.android.skyscanner.skyscanner.data.di

import com.android.skyscanner.core.reactiveX.SchedulerProvider
import com.android.skyscanner.skyscanner.domain.FlightsRepository
import dagger.Component
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
@Component(modules = [FlightsDataModule::class])
interface FlightsDataComponent {

    fun getSchedulerProvider(): SchedulerProvider

    fun getFlightsRepository(): Provider<FlightsRepository>
}