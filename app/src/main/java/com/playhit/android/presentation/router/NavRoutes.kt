package com.playhit.android.presentation.router

sealed class NavRoutes(val route: String) {
    data object Splash : NavRoutes("splash")
    data object Login : NavRoutes("login")
    data object Terms : NavRoutes("terms")
    /*data object PokemonDetail : NavRoutes("pokemonDetail")
    data object RegionDetail : NavRoutes("regionDetail")*/
}