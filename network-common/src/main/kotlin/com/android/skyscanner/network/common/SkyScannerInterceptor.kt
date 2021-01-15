package com.android.skyscanner.network.common

import okhttp3.Interceptor
import okhttp3.Response

class SkyScannerInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain
            .request()
            .newBuilder()
            .build()
        return chain.proceed(newRequest)
    }
}