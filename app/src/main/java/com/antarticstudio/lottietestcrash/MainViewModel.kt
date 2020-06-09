package com.antarticstudio.lottietestcrash

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


class MainViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {

    private val parentJob = SupervisorJob()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + parentJob

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun fakeRequest() = launch {
        withLoading {
            // Fake the request to display loader
            delay(5000)
        }
    }

    private suspend fun withLoading(block: suspend () -> Unit) {
        displayLoader()
        delay(500)
        block()
        hideLoader()
    }

    private fun displayLoader() {
        _isLoading.value = true
    }

    private fun hideLoader() {
        _isLoading.value = false
    }
}