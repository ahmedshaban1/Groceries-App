package com.ahmed.groceriesapp.ui.screens.auth.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.ahmed.groceriesapp.bases.BaseViewModel
import com.ahmed.groceriesapp.bases.TextFieldState
import com.ahmed.groceriesapp.bases.isEmail
import com.ahmed.groceriesapp.model.resourec.Resource
import com.ahmed.groceriesapp.model.user.User
import com.ahmed.groceriesapp.navigation.AuthScreens
import com.ahmed.groceriesapp.ui.screens.auth.domain.UserLoginUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val loginUserCase: UserLoginUserCase,
    private val user:User
) : BaseViewModel<AuthUiState>(){
    private val _loginState = MutableStateFlow<Resource<User>>(value = Resource.Init)
    val loginState = _loginState.asStateFlow()


    private val _email = mutableStateOf(
        TextFieldState(
        hint = "Enter email..."
     )
    )

    val email: State<TextFieldState> = _email

    private val _password = mutableStateOf(
        TextFieldState(
            hint = "Enter Password..."
        )
    )
    val password: State<TextFieldState> = _password

    fun login(email: String, password: String) {
        viewModelScope.launch {
              loginUserCase(email = email, password = password).collect {
                   _loginState.emit(it)
                  delay(5000L)
                }
        }
    }

    fun onEvent(event: LoginRegisterEvent){
        when(event){
            is LoginRegisterEvent.EnteredEmail -> {
               _email.value= _email.value.copy(
                    text = event.value
                )
            }
            is LoginRegisterEvent.EnteredPassword->{
                _password.value= _password.value.copy(
                    text = event.value
                )
            }
            LoginRegisterEvent.Login -> {
                if (!_email.value.text.isEmail()){
                    onEvent(AuthUiState.ShowSnackBar("Enter a valid email"))
                }else if(_password.value.text.length < 6){
                    onEvent(AuthUiState.ShowSnackBar("Password must be more than 6 chars"))
                }else{
                    login(_email.value.text,_password.value.text)
                }

            }
        }
    }
}


sealed class LoginRegisterEvent{
    data class EnteredEmail(val value: String): LoginRegisterEvent()
    data class EnteredPassword(val value: String): LoginRegisterEvent()
    object Login: LoginRegisterEvent()
}

sealed class AuthUiState {
    data class Navigation(val screen: AuthScreens) : AuthUiState()
    data class ShowSnackBar(val message:String) : AuthUiState()
}
