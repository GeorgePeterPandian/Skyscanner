package com.android.skyscanner.core.reactiveX

import com.android.skyscanner.core.reactiveX.SchedulerProvider
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

class TestSchedulerProvider : SchedulerProvider {

    override val ioThread: Scheduler
        get() = Schedulers.trampoline()

    override val mainThread: Scheduler
        get() = Schedulers.trampoline()
}
