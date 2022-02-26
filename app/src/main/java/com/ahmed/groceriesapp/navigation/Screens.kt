package com.ahmed.groceriesapp.navigation

sealed class Screens(val route:String) {
    object Splash:Screens("splash")
    object Home:Screens("home")
}