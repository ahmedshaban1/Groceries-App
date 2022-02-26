package com.ahmed.groceriesapp.navigation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ahmed.groceriesapp.ui.screens.splash.SplashScreen


@Composable
fun SetUpNavigation(navController:NavHostController) {
    NavHost(navController = navController,startDestination = Screens.Splash.route ){
        composable(route = Screens.Splash.route){
            SplashScreen{
                navController.navigate(Screens.Home.route){
                    popUpTo(Screens.Splash.route){
                        inclusive = true
                    }

                }
            }
        }
        composable(route = Screens.Home.route){
            Text(text = "HelloHome screen")
        }
    }
}