package com.android.skyscanner.core.di

import com.android.skyscanner.core.reactiveX.SchedulerProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreModule::class])
interface CoreComponent {
    fun getSchedulerProvider(): SchedulerProvider
}