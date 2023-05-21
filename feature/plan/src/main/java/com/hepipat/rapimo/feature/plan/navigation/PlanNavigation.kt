package com.hepipat.rapimo.feature.plan.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.hepipat.rapimo.feature.plan.PlanRoute

const val planGraphRoutePattern = "plan_graph"
const val planRoute = "plan_route"

fun NavController.navigateToPlan(navOptions: NavOptions? = null) {
    this.navigate(planRoute, navOptions)
}

fun NavGraphBuilder.planGraph(
    onStartClick: () -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit,
) {
    navigation(
        route = planGraphRoutePattern,
        startDestination = planRoute,
    ) {
        composable(route = planRoute) {
            PlanRoute(onStartClick = onStartClick)
        }
        nestedGraphs()
    }
}