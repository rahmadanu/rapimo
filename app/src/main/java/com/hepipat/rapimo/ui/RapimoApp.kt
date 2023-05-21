package com.hepipat.rapimo.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.hepipat.rapimo.core.designsystem.component.*
import com.hepipat.rapimo.core.designsystem.icon.Icon
import com.hepipat.rapimo.core.designsystem.icon.RapimoIcon
import com.hepipat.rapimo.core.designsystem.theme.GradientColors
import com.hepipat.rapimo.core.designsystem.theme.LocalGradientColors
import com.hepipat.rapimo.navigation.RapimoNavHost
import com.hepipat.rapimo.navigation.TopLevelDestination

@OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalComposeUiApi::class,
    ExperimentalLayoutApi::class
)
@Composable
fun RapimoApp(
    windowSizeClass: WindowSizeClass,
    //networkMonitor: NetworkMonitor,
    appState: RapimoAppState = rememberRapimoAppState(
        windowSizeClass = windowSizeClass
    ),
) {
    val shouldShowBottomBar = appState.shouldShowBottomBar
            && appState.currentTopLevelDestination == TopLevelDestination.HOME
            || appState.currentTopLevelDestination == TopLevelDestination.PLAN

    val shouldShowGradientBackground =
        appState.currentTopLevelDestination == TopLevelDestination.HOME

    val shouldShowNotification =
        appState.currentTopLevelDestination == TopLevelDestination.HOME

    RapimoBackground {
        RapimoGradientBackground(
            gradientColors = if (shouldShowGradientBackground) LocalGradientColors.current else GradientColors()
        ) {
            //show snackbar if offline
            //show setting dialog if it should
            
            Scaffold(
                modifier = Modifier.semantics { // learn/review
                    testTagsAsResourceId = true
                },
                containerColor = Color.Transparent,
                contentColor = MaterialTheme.colorScheme.onBackground,
                contentWindowInsets = WindowInsets(0, 0, 0, 0),
                //snackbarHost = { SnackbarHost(snackBarHostState) },
                bottomBar = {
                    if (shouldShowBottomBar) {
                        RapimoBottomBar(
                            destinations = appState.topLevelDestinations,
                            onNavigateToDestination = appState::navigateToTopLevelDestination,
                            currentDestination = appState.currentDestination,
                            modifier = Modifier.testTag("RapimoBottomBar"),
                        )
                    }
                }
            ) { padding ->
                Row(
                    Modifier
                        .fillMaxSize()
                        .padding(padding)
                        .consumedWindowInsets(
                            //learn
                            padding
                        )
                        .windowInsetsPadding(
                            //learn
                            WindowInsets.safeDrawing.only(
                                WindowInsetsSides.Horizontal
                            ),
                        ),
                ) {
                    // show nav rail if it should
                    
                    Column(Modifier.fillMaxSize()) {
                        val destination = appState.currentTopLevelDestination
                        if (destination != null) {
                            RapimoTopAppBar(
                                titleRes = destination.titleTextId,
                                actionIcon = if (shouldShowNotification) RapimoIcon.Home else null, //for testing purpose
                                actionIconContentDescription = "",
                                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                                    containerColor = Color.Transparent,
                                ),
                                onActionClick = { }, //set should something
                            )
                        }
                        
                        RapimoNavHost(navController = appState.navController)
                    }

                    // TODO: We may want to add padding or spacer when the snackbar is shown so that
                    //  content doesn't display behind it.
                }
            }
        }
    }
}

@Composable
fun RapimoBottomBar(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier,
) {
    RapimoNavigationBar(
        modifier = modifier
    ) {
        destinations.forEach { destination ->
            val selected = currentDestination.isTopLevelDestinationHierarchy(destination)
            RapimoNavigationBarItem(
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    val icon = if (selected) destination.selectedIcon else destination.unselectedIcon
                    when (icon) {
                        is Icon.ImageVectorIcon -> Icon(
                            imageVector = icon.imageVector,
                            contentDescription = null,
                        )
                        is Icon.DrawableResourceIcon -> Icon(
                            painter = painterResource(id = icon.id),
                            contentDescription = null,
                        )
                    }
                },
                label = { Text(stringResource(destination.iconTextId)) },
            )
        }
    }
}

private fun NavDestination?.isTopLevelDestinationHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false
