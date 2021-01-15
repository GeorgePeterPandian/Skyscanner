package com.android.skyscanner.uk

import android.app.Application
import com.android.skyscanner.uk.di.MyFlightsAppInjector

class MyFlightsApplication : Application() {

    companion object {
        lateinit var myFlightsApplication: MyFlightsApplication
    }

    override fun onCreate() {
        super.onCreate()
        myFlightsApplication = this
        initDagger()
    }

    private fun initDagger() {
        MyFlightsAppInjector.initialise(myFlightsApplication)
    }
}