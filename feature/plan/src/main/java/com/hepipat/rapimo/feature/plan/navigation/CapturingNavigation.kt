package com.hepipat.rapimo.feature.plan.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hepipat.rapimo.feature.plan.CapturingRoute

internal const val capturingRoute = "capturing_route"

fun NavController.navigateToCapturing() {
    this.navigate(capturingRoute)
}

fun NavGraphBuilder.capturingScreen(
    onBackClick: () -> Unit,
    //other onclick,
) {
    composable(
        route = capturingRoute,
    ) {
        CapturingRoute(onBackClick = onBackClick)
    }
}