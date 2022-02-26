package com.ahmed.groceriesapp.bases

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

open class BaseViewModel<T> :ViewModel() {
    private val _uiStateEvent = MutableSharedFlow<T>()
    val uiStateEvent = _uiStateEvent.asSharedFlow()

    fun onEvent(event:T){
        viewModelScope.launch {
            _uiStateEvent.emit(event)
        }
    }
}