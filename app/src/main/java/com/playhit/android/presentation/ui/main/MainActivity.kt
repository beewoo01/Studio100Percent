package com.playhit.android.presentation.ui.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.playhit.android.presentation.router.LocalNavScreenController
import com.playhit.android.presentation.router.NavRoutes
import com.playhit.android.presentation.theme.Studio100PercentTheme
import com.playhit.android.presentation.ui.login.LoginScreen
import com.playhit.android.presentation.ui.splash.CustomSplashScreen
import com.playhit.android.presentation.ui.terms.TermsScreen
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("MY_LOG", "MainActivity")

        enableEdgeToEdge()
        setContent {
            Studio100PercentTheme {
                myApp()
            }
        }
    }
}

@Composable
private fun myApp() {
    Log.d("MY_LOG", "Running on Android: ${android.os.Build.MODEL}")
    myLocalProvider {
        Studio100PercentTheme {
            MyNavHost()
        }

    }
}

@Composable
fun myLocalProvider(content: @Composable () -> Unit) {
    val navController = rememberNavController()

    CompositionLocalProvider(LocalNavScreenController provides navController) {
        content()
    }
}

@Composable
fun MyNavHost() {

    val navController = LocalNavScreenController.current
    val inAnimation = scaleIn(
        animationSpec = tween(300),
        initialScale = 0.92f
    ) + fadeIn(animationSpec = tween(300))
    val outAnimation = scaleOut(animationSpec = tween(300), targetScale = 0.92f) + fadeOut(
        animationSpec = tween(300)
    )


    NavHost(navController = navController, startDestination = NavRoutes.Splash.route) {
        composable(NavRoutes.Splash.route) {
            LaunchedEffect(Unit) {
                delay(2000)
                Log.d("MainActivity", "Hello")
                navController.navigate(NavRoutes.Login.route) {
                    popUpTo(NavRoutes.Splash.route) { inclusive = true }
                }
            }
            CustomSplashScreen()
        }

        composable(NavRoutes.Login.route,
            enterTransition = { inAnimation },
            exitTransition = { outAnimation }
        ) {
            LoginScreen()
        }

        composable(NavRoutes.Terms.route,
            enterTransition = { inAnimation },
            exitTransition = { outAnimation }
        ) {
            TermsScreen()
        }

        /*composable(NavRoutes.PokemonDetail.route + "/{pokedexId}",
            enterTransition = {
                // Define enter transition

                slideInHorizontally(
                    initialOffsetX = { fullWidth -> fullWidth },
                    animationSpec = tween(durationMillis = 300)
                ) + fadeIn(animationSpec = tween(durationMillis = 300))
            }, popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { fullWidth -> fullWidth },
                    animationSpec = tween(durationMillis = 300)
                ) + fadeOut(animationSpec = tween(durationMillis = 300))
            }) {
            PokemonDetailScreen()
        }

        composable(NavRoutes.RegionDetail.route + "/{region}",
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { fullWidth -> fullWidth },
                    animationSpec = tween(durationMillis = 300)
                ) + fadeIn(animationSpec = tween(durationMillis = 300))
            }, popEnterTransition = {
                EnterTransition.None
            },
            popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { fullWidth -> fullWidth },
                    animationSpec = tween(durationMillis = 300)
                ) + fadeOut(animationSpec = tween(durationMillis = 300))
            }) {
            val region = it.arguments?.getString("region").let { name ->
                RegionType.valueOf(name!!)
            }

            RegionDetailScreen(region)
        }*/
    }
}
