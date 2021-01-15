package com.android.skyscanner.skyscanner.data.remote

import com.android.skyscanner.network.common.getCommonRetrofit
import com.android.skyscanner.skyscanner.data.BuildConfig
import com.android.skyscanner.skyscanner.data.model.FlightsAM
import com.squareup.moshi.Moshi
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

class FlightsApiService {

    fun loadFlights(): Single<FlightsAM> = service.loadFlights()

    private interface FlightsService {

        @GET("flights.json")
        fun loadFlights(): Single<FlightsAM>
    }

    private val service by lazy {
        retrofit.create(FlightsService::class.java)
    }

    private val retrofit: Retrofit by lazy {
        getCommonRetrofit(BuildConfig.REST_API_URL, BuildConfig.DEBUG)
            .newBuilder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }

    private val moshi: Moshi by lazy {
        Moshi
            .Builder()
            .add(FlightJsonAdapter())
            .build()
    }
}