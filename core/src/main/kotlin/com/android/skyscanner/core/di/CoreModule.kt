package com.android.skyscanner.core.di

import com.android.skyscanner.core.reactiveX.DefaultSchedulerProvider
import com.android.skyscanner.core.reactiveX.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CoreModule {

    @Provides
    @Singleton
    fun provideSchedulerProvider(): SchedulerProvider = DefaultSchedulerProvider()

}