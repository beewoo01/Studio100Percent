package com.playhit.studio.presentation.router

sealed class NavRoutes(val route: String) {
    data object Splash : NavRoutes("splash")
    data object Login : NavRoutes("login")
    data object Terms : NavRoutes("terms")
    data object Join : NavRoutes("join")
    data object Exercise : NavRoutes("exercise")
    data object Find : NavRoutes("find")
    data object Home : NavRoutes("home")
}