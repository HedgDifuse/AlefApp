package com.hedgdifuse.alefapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hedgdifuse.alefapp.router.RetrofitRouterI
import com.hedgdifuse.alefapp.router.RouterFactory
import com.hedgdifuse.alefapp.viewmodel.state.ViewModelState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * [ImagesViewModel] - simple viewModel for get images from api.
 */
class ImagesViewModel : ViewModel() {

    val images: MutableLiveData<ViewModelState<List<String>>> by lazy {
        MutableLiveData<ViewModelState<List<String>>>().also {
            fetchImages()
        }
    }

    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    private val router = RouterFactory.create<RetrofitRouterI>()

    fun fetchImages() = coroutineScope.launch {
        images.postValue(ViewModelState.Loading())

        images.postValue(
            try {
                ViewModelState.Success(router.images())
            } catch (e: Exception) {
                println("got an error: ${e.localizedMessage}")

                ViewModelState.Errored(e)
            }
        )
    }
}