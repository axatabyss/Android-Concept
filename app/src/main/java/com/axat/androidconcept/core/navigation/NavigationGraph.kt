package com.axat.androidconcept.core.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.axat.androidconcept.features.presentation.HomeScreen


@Composable
fun NavigationGraph(
    navController: NavHostController,
) {

    NavHost(
        navController = navController,
        startDestination = NavigationRoute.HOME_SCREEN
    ) {

        composable(NavigationRoute.HOME_SCREEN) {
            HomeScreen(navController = navController)
        }

    }

}