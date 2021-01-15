package com.android.skyscanner.core.presentation

data class Resource<out T>(val state: State, val data: T?, val message: String? = null) {
    sealed class State {
        object Loading : State()
        object Success : State()
        object Error : State()
    }
}