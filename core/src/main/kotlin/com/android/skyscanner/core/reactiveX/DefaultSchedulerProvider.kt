package com.android.skyscanner.core.reactiveX

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

class DefaultSchedulerProvider : SchedulerProvider {

    override val ioThread: Scheduler
        get() = Schedulers.io()

    override val mainThread: Scheduler
        get() = AndroidSchedulers.mainThread()
}