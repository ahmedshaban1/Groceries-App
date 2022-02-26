package com.ahmed.groceriesapp.navigation

sealed class Screens(val route:String) {
    object Splash:Screens("splash")
    object Home:Screens("home")
}

sealed class AuthScreens(val route: String){
    object GetStarted:AuthScreens("get_started")
    object Login:AuthScreens("login")
    object Register:AuthScreens("register")
}

object NestedGraphs{
    const val AUTH ="auth"
}