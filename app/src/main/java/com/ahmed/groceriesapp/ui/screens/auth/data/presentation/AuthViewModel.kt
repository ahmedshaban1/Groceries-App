package com.ahmed.groceriesapp.ui.screens.auth.data.presentation

import com.ahmed.groceriesapp.bases.BaseViewModel
import com.ahmed.groceriesapp.navigation.AuthScreens
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor() : BaseViewModel<AuthUiState>()



sealed class AuthUiState {
    data class Navigation(val screen: AuthScreens) : AuthUiState()
}
