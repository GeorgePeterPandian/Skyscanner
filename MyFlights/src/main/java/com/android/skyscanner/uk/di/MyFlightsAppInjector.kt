package com.android.skyscanner.uk.di

import android.app.Application
import android.content.Context
import com.android.skyscanner.core.di.CoreInjector
import com.android.skyscanner.skyscanner.data.di.FlightsDataInjector
import com.android.skyscanner.uk.flights.di.FlightsUIInjector

object MyFlightsAppInjector {

    fun initialise(application: Application) {
        initialiseDependencies(application)
    }

    private fun initialiseDependencies(application: Application) {
        val context = application as Context
        CoreInjector.initialise()
        FlightsDataInjector.initialise(context)
        FlightsUIInjector.initialise()
    }
}