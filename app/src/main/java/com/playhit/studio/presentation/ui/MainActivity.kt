package com.playhit.studio.presentation.ui

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
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.playhit.studio.presentation.router.LocalNavScreenController
import com.playhit.studio.presentation.router.NavRoutes
import com.playhit.studio.presentation.theme.Studio100PercentTheme
import com.playhit.studio.presentation.ui.exercise.ExerciseScreen
import com.playhit.studio.presentation.ui.find.FindMainScreen
import com.playhit.studio.presentation.ui.home.HomeScreen
import com.playhit.studio.presentation.ui.join.JoinScreen
import com.playhit.studio.presentation.ui.login.LoginScreen
import com.playhit.studio.presentation.ui.splash.CustomSplashScreen
import com.playhit.studio.presentation.ui.terms.TermsScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
    MyLocalProvider {
        MyNavHost()
    }
}

@Composable
fun MyLocalProvider(content: @Composable () -> Unit) {
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
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { fullWidth -> fullWidth },
                    animationSpec = tween(durationMillis = 300)
                ) + fadeIn(animationSpec = tween(durationMillis = 300))
            }, popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { fullWidth -> fullWidth },
                    animationSpec = tween(durationMillis = 300)
                ) + fadeOut(animationSpec = tween(durationMillis = 300))
            }
            /*enterTransition = { inAnimation },
            exitTransition = { outAnimation }*/
        ) {
            LoginScreen()
        }

        composable(NavRoutes.Terms.route,
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { fullWidth -> fullWidth },
                    animationSpec = tween(durationMillis = 300)
                ) + fadeIn(animationSpec = tween(durationMillis = 300))
            }, popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { fullWidth -> fullWidth },
                    animationSpec = tween(durationMillis = 300)
                ) + fadeOut(animationSpec = tween(durationMillis = 300))
            }
        ) {
            TermsScreen()
        }

        composable(NavRoutes.Find.route + "/{initialState}",
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { fullWidth -> fullWidth },
                    animationSpec = tween(durationMillis = 300)
                ) + fadeIn(animationSpec = tween(durationMillis = 300))
            }, popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { fullWidth -> fullWidth },
                    animationSpec = tween(durationMillis = 300)
                ) + fadeOut(animationSpec = tween(durationMillis = 300))
            }
        ) {
            FindMainScreen(initialState = it.arguments?.getString("initialState")?.toInt() ?: 0)
        }

        composable(
            NavRoutes.Join.route,
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { fullWidth -> fullWidth },
                    animationSpec = tween(durationMillis = 300)
                ) + fadeIn(animationSpec = tween(durationMillis = 300))
            }, popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { fullWidth -> fullWidth },
                    animationSpec = tween(durationMillis = 300)
                ) + fadeOut(animationSpec = tween(durationMillis = 300))
            }
        ) {
            JoinScreen()
        }

        composable(
            NavRoutes.Exercise.route,
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { fullWidth -> fullWidth },
                    animationSpec = tween(durationMillis = 300)
                ) + fadeIn(animationSpec = tween(durationMillis = 300))
            }, popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { fullWidth -> fullWidth },
                    animationSpec = tween(durationMillis = 300)
                ) + fadeOut(animationSpec = tween(durationMillis = 300))
            }
        ) {
            ExerciseScreen()
        }

        composable(
            NavRoutes.Home.route,
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { fullWidth -> fullWidth },
                    animationSpec = tween(durationMillis = 300)
                ) + fadeIn(animationSpec = tween(durationMillis = 300))
            },
            popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { fullWidth -> fullWidth },
                    animationSpec = tween(durationMillis = 300)
                ) + fadeOut(animationSpec = tween(durationMillis = 300))
            }
        ) {
            HomeScreen()
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
