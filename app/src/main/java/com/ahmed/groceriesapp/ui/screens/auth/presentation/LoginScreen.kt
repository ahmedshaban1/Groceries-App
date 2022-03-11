package com.ahmed.groceriesapp.ui.screens.auth.presentation

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ahmed.groceriesapp.R
import com.ahmed.groceriesapp.model.resourec.Resource
import com.ahmed.groceriesapp.model.user.User
import com.ahmed.groceriesapp.navigation.AuthScreens
import com.ahmed.groceriesapp.navigation.AuthScreens.Register
import com.ahmed.groceriesapp.ui.common.*
import com.ahmed.groceriesapp.ui.screens.auth.presentation.AuthUiState.Navigation
import com.ahmed.groceriesapp.ui.theme.GroceriesAppTheme
import com.ahmed.groceriesapp.ui.theme.spacing
import kotlinx.coroutines.flow.collect

@Composable
fun LoginScreen(viewModel: AuthViewModel = hiltViewModel(), naveTo: (AuthScreens) -> Unit) {
    val email = viewModel.email.value
    val password = viewModel.password.value
    val scaffoldState = rememberScaffoldState()
    Scaffold(scaffoldState = scaffoldState) {
        Column(
            Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(MaterialTheme.spacing.medium)
        )
        {
            val login by viewModel.loginState.collectAsState()
            LaunchedEffect(key1 = Unit) {
                viewModel.uiStateEvent.collect { event ->
                    when (event) {
                        is Navigation -> naveTo(event.screen)
                        is AuthUiState.ShowSnackBar -> {
                            scaffoldState.snackbarHostState.showSnackbar(message = event.message)
                        }
                    }
                }
            }
            LoginRegisterHeader(
                title = stringResource(R.string.login),
                subTitle = stringResource(R.string.login_hint)
            )
            HandleLoginResponse(login,viewModel)
            VerticalSpacer()
            VerticalSpacer()
            GTextField(
                value = email.text,
                label = email.hint,
                keyboardType = KeyboardType.Email,
                onValueChange = {
                    viewModel.onEvent(LoginRegisterEvent.EnteredEmail(it))
                }
            )
            VerticalSpacer()
            GPasswordTextField(
                value = password.text,
                label = password.hint,
                onValueChange = {
                    viewModel.onEvent(LoginRegisterEvent.EnteredPassword(it))
                }
            )
            VerticalSpacer(MaterialTheme.spacing.small)
            Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.TopEnd) {
                Text(text = stringResource(R.string.forget_password))
            }
            VerticalSpacer()
            GButton(
                text = stringResource(id = R.string.login),
                modifier = Modifier.fillMaxWidth()
            ) {
                viewModel.onEvent(LoginRegisterEvent.Login)
            }
            VerticalSpacer()
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(text = "Don't have an account?")
                Text(text = stringResource(id = R.string.sign_up),
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier.clickable {
                        viewModel.onEvent(Navigation(Register))
                    })
            }
            VerticalSpacer(50.dp)
        }
    }

}

@Composable
fun HandleLoginResponse(login: Resource<User>, viewModel: AuthViewModel) {
   when(login){
       is Resource.Error ->{
           viewModel.onEvent(AuthUiState.ShowSnackBar("Email and password are not matched"))
       }
       Resource.Init -> {}
       Resource.Loading -> {
           Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
               CircularProgressIndicator()
           }
       }
       is Resource.Success -> {
           Toast.makeText(LocalContext.current,"You have logged in successfully",Toast.LENGTH_SHORT).show()
       }
   }
}


@Preview
@Composable
fun LoginScreenPreview() {
    GroceriesAppTheme {
        LoginScreen {}
    }
}