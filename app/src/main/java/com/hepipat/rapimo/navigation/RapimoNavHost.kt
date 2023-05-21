package com.hepipat.rapimo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.hepipat.rapimo.feature.plan.navigation.planGraph
import com.hepipat.rapimo.feature.plan.navigation.capturingScreen
import com.hepipat.rapimo.feature.plan.navigation.navigateToCapturing
import com.hepipat.rapimo.feature.home.navigation.homeRoute
import com.hepipat.rapimo.feature.home.navigation.homeScreen

@Composable
fun RapimoNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = homeRoute,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        // TODO: handle topic clicks from each top level destination
        homeScreen(onItemClick = {})
        planGraph(
            onStartClick = {
                navController.navigateToCapturing()
            },
            nestedGraphs = {
                capturingScreen(
                    onBackClick = navController::popBackStack,
                )
            }
        )
    }
}