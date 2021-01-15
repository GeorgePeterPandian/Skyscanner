package com.android.skyscanner.core.extensions

import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

fun Disposable.disposeWith(disposables: CompositeDisposable) {
    disposables.add(this)
}
