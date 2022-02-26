package com.ahmed.groceriesapp.navigation

sealed class Screens(val route:String) {
    object Splash:Screens("splash")
    object Home:Screens("home")
}

sealed class AuthScreens(val route: String){
    object Login:AuthScreens("login")
}

object NestedGraphs{
    const val AUTH ="auth"
}