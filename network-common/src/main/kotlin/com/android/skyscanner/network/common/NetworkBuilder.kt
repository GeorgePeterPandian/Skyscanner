package com.android.skyscanner.network.common

import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

private var retrofit: Retrofit? = null
private var okHttp: OkHttpClient? = null

fun getCommonRetrofit(restApiUrl: String, isDebug: Boolean): Retrofit =
    retrofit ?: initRetrofit(restApiUrl, isDebug)

private fun initRetrofit(restApiUrl: String, isDebug: Boolean) =
    Retrofit
        .Builder()
        .client(getCommonOkHttp(isDebug))
        .baseUrl(restApiUrl)
        .build()
        .also { retrofit = it }

fun getCommonOkHttp(isDebug: Boolean): OkHttpClient = okHttp ?: initOkHttp(isDebug)

private fun initOkHttp(isDebug: Boolean): OkHttpClient {
    val loggingInterceptor = HttpLoggingInterceptor().setLevel(
        when {
            isDebug -> HttpLoggingInterceptor.Level.BASIC
            else -> HttpLoggingInterceptor.Level.NONE
        }
    )
    return OkHttpClient
        .Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .connectionPool(ConnectionPool(0, 1, TimeUnit.NANOSECONDS))
        .addInterceptor(loggingInterceptor)
        .addInterceptor(SkyScannerInterceptor())
        .build()
        .also { okHttp = it }
}