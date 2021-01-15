package com.android.skyscanner.skyscanner.domain.usecases

import com.android.skyscanner.core.architecture.UseCase
import com.android.skyscanner.core.extensions.disposeWith
import com.android.skyscanner.core.extensions.isConnectionError
import com.android.skyscanner.core.reactiveX.SchedulerProvider
import com.android.skyscanner.skyscanner.domain.FlightsRepository
import com.android.skyscanner.skyscanner.domain.model.FlightsDM
import com.android.skyscanner.skyscanner.domain.model.ItineraryDM
import javax.inject.Inject

class LoadFlightsUseCase @Inject constructor(
    private val repository: FlightsRepository,
    private val schedulerProvider: SchedulerProvider
) : UseCase<LoadFlightsUseCase.Result>() {

    override fun execute(onResult: (result: Result) -> Unit) =
        repository.loadFlights()
            .map<Result> { Result.Success(it) }
            .onErrorReturn(::getErrorResult)
            .subscribeOn(schedulerProvider.ioThread)
            .observeOn(schedulerProvider.mainThread)
            .subscribe(onResult)
            .disposeWith(compositeDisposable)

    private fun getErrorResult(throwable: Throwable): Result = when {
        throwable.isConnectionError() -> Result.ErrorConnection
        else -> Result.ErrorUnknown(throwable)
    }

    sealed class Result {
        data class Success(val flights: FlightsDM) : Result()
        data class ErrorUnknown(val throwable: Throwable) : Result()
        object ErrorConnection : Result()
    }
}