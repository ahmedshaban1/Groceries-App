package com.ahmed.groceriesapp.navigation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.ahmed.groceriesapp.navigation.NestedGraphs.AUTH
import com.ahmed.groceriesapp.ui.screens.auth.data.presentation.GetStartedScreen
import com.ahmed.groceriesapp.ui.screens.auth.data.presentation.LoginScreen
import com.ahmed.groceriesapp.ui.screens.auth.data.presentation.RegisterScreen
import com.ahmed.groceriesapp.ui.screens.splash.SplashScreen


@Composable
fun SetUpNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.Splash.route) {
        composable(route = Screens.Splash.route) {
            SplashScreen {
                navController.navigate(AUTH) {
                    popUpTo(Screens.Splash.route) {
                        inclusive = true
                    }

                }
            }
        }
        composable(route = Screens.Home.route) {
            Text(text = "HelloHome screen")
        }
        loginGraph(navController = navController)
    }
}

fun NavGraphBuilder.loginGraph(navController: NavController) {
    navigation(startDestination = AuthScreens.GetStarted.route, route = "auth") {
        composable(AuthScreens.GetStarted.route) {
            GetStartedScreen{
                navController.navigate(it.route)
            }
        }
        composable(AuthScreens.Login.route){
            LoginScreen{
                navController.navigate(it.route)
            }
        }
        composable(AuthScreens.Register.route){
            RegisterScreen{
                navController.popBackStack()
            }
        }
    }
}