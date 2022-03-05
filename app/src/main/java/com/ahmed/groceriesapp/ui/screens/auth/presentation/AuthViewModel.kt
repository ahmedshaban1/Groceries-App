package com.ahmed.groceriesapp.ui.screens.auth.presentation

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.ahmed.groceriesapp.bases.BaseViewModel
import com.ahmed.groceriesapp.navigation.AuthScreens
import com.ahmed.groceriesapp.ui.screens.auth.domain.UserLoginUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val loginUserCase: UserLoginUserCase
) : BaseViewModel<AuthUiState>(){
    init {
        login()
    }
    fun login(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
              loginUserCase("ahme@ahmed","123").collect {
                    Log.d("results",it.toString())
                }

            }
        }
    }
}



sealed class AuthUiState {
    data class Navigation(val screen: AuthScreens) : AuthUiState()
}
