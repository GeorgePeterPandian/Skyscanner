package com.android.skyscanner.skyscanner.domain.di

import com.android.skyscanner.core.reactiveX.SchedulerProvider
import com.android.skyscanner.skyscanner.domain.FlightsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
class FlightsDomainModule(
    private val repository: Provider<FlightsRepository>,
    private val schedulerProvider: SchedulerProvider
) {

    @Provides
    fun provideFlightsRepository(): FlightsRepository = repository.get()

    @Provides
    fun provideDomainSchedulerProvider(): SchedulerProvider = schedulerProvider
}