package com.android.skyscanner.skyscanner.data.di

import com.android.skyscanner.core.reactiveX.DefaultSchedulerProvider
import com.android.skyscanner.core.reactiveX.SchedulerProvider
import com.android.skyscanner.skyscanner.data.FlightsDS
import com.android.skyscanner.skyscanner.data.FlightsRepositoryImpl
import com.android.skyscanner.skyscanner.data.remote.FlightsApiDS
import com.android.skyscanner.skyscanner.data.remote.FlightsApiService
import com.android.skyscanner.skyscanner.domain.FlightsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [FlightsDataModule.BindModule::class])
internal class FlightsDataModule {

    @Provides
    fun provideFlightsApiService(): FlightsApiService = FlightsApiService()

    @Provides
    fun provideFlightsSchedulerProvider(): SchedulerProvider = DefaultSchedulerProvider()

    @Module
    interface BindModule {

        @Binds
        fun bindFlightsRemoteDataSource(remoteDS: FlightsApiDS): FlightsDS.Remote

        @Binds
        fun bindFlightsRepository(repositoryImpl: FlightsRepositoryImpl): FlightsRepository
    }
}