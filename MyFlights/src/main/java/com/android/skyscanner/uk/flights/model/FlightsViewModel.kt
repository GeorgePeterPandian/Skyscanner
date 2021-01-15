package com.android.skyscanner.uk.flights.model

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.skyscanner.core.extensions.setError
import com.android.skyscanner.core.extensions.setLoading
import com.android.skyscanner.core.extensions.setSuccess
import com.android.skyscanner.core.presentation.Resource
import com.android.skyscanner.skyscanner.domain.model.FlightsDM
import com.android.skyscanner.skyscanner.domain.usecases.LoadFlightsUseCase
import com.android.skyscanner.skyscanner.domain.usecases.LoadFlightsUseCase.Result
import javax.inject.Inject

class FlightsViewModel @Inject constructor(private val useCase: LoadFlightsUseCase) : ViewModel() {

    companion object {
        const val CONNECTION_ERROR = "connection_error"
    }

    private val _flightsLiveData = MutableLiveData<Resource<List<FlightsUIM>>>()
    val flightsLiveData: LiveData<Resource<List<FlightsUIM>>>
        get() = _flightsLiveData

    fun loadBreeds() {
        if (_flightsLiveData.value != null) return
        useCase.cancel()
        _flightsLiveData.setLoading()
        useCase.execute(::onFetchPostsResult)
    }

    fun retry() {
        useCase.cancel()
        _flightsLiveData.setLoading()
        useCase.execute(::onFetchPostsResult)
    }

    @VisibleForTesting
    private fun onFetchPostsResult(result: Result) {
        when (result) {
            is Result.Success -> onFetchSuccess(result.flights)
            is Result.ErrorConnection -> onErrorConnection()
            is Result.ErrorUnknown -> onErrorUnknown()
        }
    }

    private fun onFetchSuccess(flights: FlightsDM) {
        _flightsLiveData.setSuccess(flights.toUIM())
    }

    private fun onErrorConnection() {
        _flightsLiveData.setError(CONNECTION_ERROR)
    }

    private fun onErrorUnknown() {
        _flightsLiveData.setError()
    }

    override fun onCleared() {
        super.onCleared()
        useCase.cancel()
    }
}