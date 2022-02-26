package com.ahmed.groceriesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.ahmed.groceriesapp.navigation.SetUpNavigation
import com.ahmed.groceriesapp.ui.screens.splash.SplashScreen
import com.ahmed.groceriesapp.ui.theme.GroceriesAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GroceriesAppTheme {
                val navController = rememberNavController()
                SetUpNavigation(navController = navController)
            }
        }
    }
}