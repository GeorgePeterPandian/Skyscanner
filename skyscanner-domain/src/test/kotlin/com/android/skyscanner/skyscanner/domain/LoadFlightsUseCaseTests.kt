package com.android.skyscanner.skyscanner.domain

import com.android.skyscanner.core.reactiveX.SchedulerProvider
import com.android.skyscanner.core.reactiveX.TestSchedulerProvider
import com.android.skyscanner.skyscanner.domain.model.FlightsDM
import com.android.skyscanner.skyscanner.domain.model.ItineraryDM
import com.android.skyscanner.skyscanner.domain.usecases.LoadFlightsUseCase
import io.reactivex.rxjava3.core.Single
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import java.net.ConnectException

@RunWith(MockitoJUnitRunner::class)
class LoadFlightsUseCaseTests {
    @Mock
    private lateinit var repository: FlightsRepository

    @Mock
    private lateinit var responseDM: FlightsDM


    private lateinit var useCase: LoadFlightsUseCase

    private val schedulerProvider: SchedulerProvider = TestSchedulerProvider()

    private var result: LoadFlightsUseCase.Result? = null

    @Before
    fun setUp() {
        useCase = LoadFlightsUseCase(repository, schedulerProvider)
    }

    @Test
    fun `gets flights data successfully`() {
        val expected = LoadFlightsUseCase.Result.Success(responseDM)
        BDDMockito.given(repository.loadFlights())
            .willReturn(Single.just(responseDM))
        useCase.execute { result = it }
        assertEquals(expected, result)
    }

    @Test
    fun `handles connection error`() {
        val expected = LoadFlightsUseCase.Result.ErrorConnection
        BDDMockito.given(repository.loadFlights())
            .willReturn(Single.error(ConnectException()))
        useCase.execute { result = it }
        assertEquals(expected, result)
    }

    @Test
    fun `handles unknown error`() {
        val runtimeException = RuntimeException()
        val expected = LoadFlightsUseCase.Result.ErrorUnknown(runtimeException)
        BDDMockito.given(repository.loadFlights())
            .willReturn(Single.error(runtimeException))
        useCase.execute { result = it }
        assertEquals(expected, result)
    }
}