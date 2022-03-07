package com.ahmed.groceriesapp.ui.screens.auth.presentation

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ahmed.groceriesapp.R
import com.ahmed.groceriesapp.model.resourec.Resource
import com.ahmed.groceriesapp.navigation.AuthScreens
import com.ahmed.groceriesapp.navigation.AuthScreens.Register
import com.ahmed.groceriesapp.ui.common.*
import com.ahmed.groceriesapp.ui.screens.auth.presentation.AuthUiState.Navigation
import com.ahmed.groceriesapp.ui.theme.GroceriesAppTheme
import com.ahmed.groceriesapp.ui.theme.spacing
import kotlinx.coroutines.flow.collect
import kotlin.math.log

@Composable
fun LoginScreen(viewModel: AuthViewModel = hiltViewModel(), naveTo: (AuthScreens) -> Unit) {
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
                }
            }
        }
        if(login is Resource.Loading){
            CircularProgressIndicator()
        }
        if(login is Resource.Error){
           Text(text = "Error ${(login as Resource.Error).errorCode}")
        }
        if(login is Resource.Success){
            Text(text = "Success ${(login as Resource.Success).data}")
        }
        LoginRegisterHeader(
            title = stringResource(R.string.login),
            subTitle = stringResource(R.string.login_hint)
        )
        VerticalSpacer()
        VerticalSpacer()
        var email by remember {
            mutableStateOf("")
        }

        GTextField(
            value = email,
            label = "Email",
            keyboardType = KeyboardType.Email,
            onValueChange = {
                email = it
            }
        )
        VerticalSpacer()
        GPasswordTextField(
            value = email,
            label = "Password",
            onValueChange = {
                email = it
            }
        )
        VerticalSpacer(MaterialTheme.spacing.small)
        Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.TopEnd) {
            Text(text = stringResource(R.string.forget_password))
        }
        VerticalSpacer()
        GButton(text = stringResource(id = R.string.login), modifier = Modifier.fillMaxWidth()) {

        }
        VerticalSpacer()
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(text = "Don't have an account?")
            Text(text = stringResource(id = R.string.sign_up), color = MaterialTheme.colors.primary,
                modifier = Modifier.clickable {
                    viewModel.onEvent(Navigation(Register))
                })
        }
        VerticalSpacer(50.dp)
    }
}


@Preview
@Composable
fun LoginScreenPreview() {
    GroceriesAppTheme {
        LoginScreen {}
    }
}