package com.android.skyscanner.core.di

object CoreInjector {

    private lateinit var component: CoreComponent

    fun initialise() {
        component = DaggerCoreComponent.builder().coreModule(CoreModule()).build()
    }
}