package com.ahmed.groceriesapp.ui.screens.auth.presentation

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.ahmed.groceriesapp.bases.BaseViewModel
import com.ahmed.groceriesapp.model.resourec.Resource
import com.ahmed.groceriesapp.model.user.User
import com.ahmed.groceriesapp.navigation.AuthScreens
import com.ahmed.groceriesapp.ui.screens.auth.domain.UserLoginUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val loginUserCase: UserLoginUserCase
) : BaseViewModel<AuthUiState>(){
    private val _loginState = MutableStateFlow<Resource<User>>(value = Resource.Init)
    val loginState = _loginState.asStateFlow()
    init {
        login()
    }
    fun login(){
        viewModelScope.launch {
              loginUserCase("ahmed@ahmed","123").collect {
                   _loginState.emit(it)
                }
        }
    }
}



sealed class AuthUiState {
    data class Navigation(val screen: AuthScreens) : AuthUiState()
}
