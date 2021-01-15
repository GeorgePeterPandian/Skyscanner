package com.android.skyscanner.core.reactiveX

import io.reactivex.rxjava3.core.Scheduler

interface SchedulerProvider {
    val ioThread: Scheduler
    val mainThread: Scheduler
}