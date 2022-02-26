package com.ahmed.groceriesapp.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ahmed.groceriesapp.R
import com.ahmed.groceriesapp.R.string.*
import com.ahmed.groceriesapp.navigation.AuthScreens
import com.ahmed.groceriesapp.navigation.AuthScreens.Login
import com.ahmed.groceriesapp.ui.common.GButton
import com.ahmed.groceriesapp.ui.common.VerticalSpacer
import com.ahmed.groceriesapp.ui.screens.auth.AuthUiState.Navigation
import com.ahmed.groceriesapp.ui.theme.GroceriesAppTheme
import kotlinx.coroutines.flow.collect

@Composable
fun GetStartedScreen(viewModel: AuthViewModel= hiltViewModel(),naveTo:(AuthScreens)->Unit) {
    Scaffold(Modifier.fillMaxSize()) {
        LaunchedEffect(key1 = true){
            viewModel.uiStateEvent.collect {
                when(it){
                    is Navigation -> naveTo(it.screen)
                }
            }
        }
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painterResource(id = R.drawable.getstartbg),
                contentDescription = "get_started",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Column(modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally,verticalArrangement = Arrangement.Bottom) {
                Text(
                    stringResource(welcome_to_our_store),
                    style = typography.h3.copy(color = Color.White),
                    textAlign = TextAlign.Center
                )
               VerticalSpacer()
                Text(text = stringResource(id = get_started_hint),
                    style = typography.h6.copy(color = Color.White,fontSize = 14.sp),
                    textAlign = TextAlign.Center)
               VerticalSpacer()
                GButton(text = "Get Started",modifier = Modifier.fillMaxWidth(fraction = .6f)) {
                    viewModel.onEvent(Navigation(Login))
                }
                VerticalSpacer(50.dp)

            }
        }



    }
}

@Preview
@Composable
fun GetStartedPreview() {
    GroceriesAppTheme {
        GetStartedScreen{}
    }
}