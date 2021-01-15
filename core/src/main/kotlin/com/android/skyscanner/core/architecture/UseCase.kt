package com.android.skyscanner.core.architecture

import io.reactivex.rxjava3.disposables.CompositeDisposable

abstract class UseCase<T> {

    protected val compositeDisposable: CompositeDisposable = CompositeDisposable()

    abstract fun execute(onResult: (result: T) -> Unit)

    open fun cancel() {
        compositeDisposable.clear()
    }
}