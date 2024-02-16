package com.axat.androidconcept.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.axat.androidconcept.ui.screens.AnimationScreen
import com.axat.androidconcept.ui.screens.ChartBarScreen
import com.axat.androidconcept.ui.screens.HomeScreen
import com.axat.androidconcept.ui.screens.ShapesScreen


@Composable
fun NavigationGraph() {


    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavigationRoute.HOME_SCREEN
    ) {

        composable(NavigationRoute.HOME_SCREEN) {
            HomeScreen(navController = navController)
        }

        composable(NavigationRoute.SHAPES_SCREEN) {
            ShapesScreen()
        }

        composable(NavigationRoute.CHARTBAR_SCREEN) {
            ChartBarScreen()
        }

        composable(NavigationRoute.ANIMATION_SCREEN) {
            AnimationScreen()
        }

    }

}