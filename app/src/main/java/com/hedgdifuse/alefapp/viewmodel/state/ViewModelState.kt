package com.hedgdifuse.alefapp.viewmodel.state

/**
 * [ViewModelState] - state for viewModel, implement MVI architecture
 */
sealed class ViewModelState<T> {
    class Success<T>(val data: T): ViewModelState<T>()
    class Errored<T>(val error: Exception): ViewModelState<T>()

    class Loading<T>: ViewModelState<T>()
}