package com.ahmed.groceriesapp.ui.screens.auth.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ahmed.groceriesapp.R
import com.ahmed.groceriesapp.navigation.AuthScreens
import com.ahmed.groceriesapp.ui.common.*
import com.ahmed.groceriesapp.ui.screens.auth.presentation.AuthUiState.Navigation
import com.ahmed.groceriesapp.ui.theme.GroceriesAppTheme
import com.ahmed.groceriesapp.ui.theme.spacing
import kotlinx.coroutines.flow.collect

@Composable
fun RegisterScreen(viewModel: AuthViewModel = hiltViewModel(), naveTo:(AuthScreens)->Unit) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(MaterialTheme.spacing.medium))
    {
        LaunchedEffect(key1 = Unit){
            viewModel.uiStateEvent.collect { event->
                when (event){
                    is Navigation -> naveTo(event.screen)
                }
            }
        }
        LoginRegisterHeader(
            title = stringResource(R.string.sign_up),
            subTitle = stringResource(R.string.enter_register_info)
        )

        var email by remember {
            mutableStateOf("")
        }

        GTextField(
            value = email,
            label = "Username",
            onValueChange = {
                email = it
            }
        )
        VerticalSpacer()
        GTextField(
            value = email,
            label = stringResource(R.string.email),
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
        Text(text = stringResource(R.string.policy))
        VerticalSpacer()
        GButton(text = stringResource(id = R.string.sign_up),modifier = Modifier.fillMaxWidth()) {

        }
        VerticalSpacer()
        Row(Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Center) {
            Text(text = "Already have account?")
            Text(text = stringResource(id = R.string.login),color = MaterialTheme.colors.primary,
                modifier = Modifier.clickable {
                    viewModel.onEvent(Navigation(AuthScreens.Login))
                })
        }
        VerticalSpacer(50.dp)
    }


}


@Preview
@Composable
fun RegisterPreview() {
    GroceriesAppTheme {
        RegisterScreen{}
    }
}