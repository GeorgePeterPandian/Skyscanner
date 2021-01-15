package com.android.skyscanner.core.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.android.skyscanner.core.architecture.ViewModelFactory

inline fun <reified VM : ViewModel> AppCompatActivity.activityViewModel(viewModelFactory: ViewModelFactory<VM>? = null): Lazy<VM> =
    lazy { ViewModelProviders.of(this, viewModelFactory).get(VM::class.java) }