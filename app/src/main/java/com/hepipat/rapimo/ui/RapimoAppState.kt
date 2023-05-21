package com.hepipat.rapimo.ui

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.core.os.trace
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.hepipat.rapimo.feature.plan.navigation.planRoute
import com.hepipat.rapimo.feature.plan.navigation.navigateToPlan
import com.hepipat.rapimo.feature.home.navigation.homeRoute
import com.hepipat.rapimo.feature.home.navigation.navigateToHome
import com.hepipat.rapimo.navigation.TopLevelDestination
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberRapimoAppState(
    windowSizeClass: WindowSizeClass,
    //networkMonitor: NetworkMonitor,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController(),
): RapimoAppState {
    return remember(navController, coroutineScope, windowSizeClass){
        RapimoAppState(navController, coroutineScope, windowSizeClass)
    }
}

class RapimoAppState(
    val navController: NavHostController,
    val coroutineScope: CoroutineScope,
    val windowSizeClass: WindowSizeClass,
    //networkMonitor: NetworkMonitor,
) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            homeRoute -> TopLevelDestination.HOME
            planRoute -> TopLevelDestination.PLAN
            else -> null
        }

    val shouldShowBottomBar: Boolean
        get() = windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact

    val shouldShowNavRail: Boolean
        get() = !shouldShowBottomBar


    //val shouldShowSettingsDialog
    //val isOffline

    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.values().asList()

    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        trace("Navigation: ${topLevelDestination.name}") {
            val topLevelNavOptions = navOptions {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }

            when (topLevelDestination) {
                TopLevelDestination.HOME -> navController.navigateToHome(topLevelNavOptions)
                TopLevelDestination.PLAN -> navController.navigateToPlan(topLevelNavOptions)
                else -> {}
            }
        }
    }
}

//private fun NavigationTrackingSideEffect / track JankStats