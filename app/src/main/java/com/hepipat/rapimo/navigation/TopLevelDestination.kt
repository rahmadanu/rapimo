package com.hepipat.rapimo.navigation

import com.hepipat.rapimo.R
import com.hepipat.rapimo.core.designsystem.icon.Icon
import com.hepipat.rapimo.core.designsystem.icon.Icon.ImageVectorIcon
import com.hepipat.rapimo.core.designsystem.icon.RapimoIcon

enum class TopLevelDestination(
    val selectedIcon: Icon,
    val unselectedIcon: Icon,
    val iconTextId: Int,
    val titleTextId: Int,
) {
    HOME(
        selectedIcon = ImageVectorIcon(RapimoIcon.Home),
        unselectedIcon = ImageVectorIcon(RapimoIcon.Home), // should use home border
        iconTextId = R.string.home,
        titleTextId = R.string.home,
    ),
    PLAN(
        selectedIcon = ImageVectorIcon(RapimoIcon.Capture),
        unselectedIcon = ImageVectorIcon(RapimoIcon.Capture), // should use home border
        iconTextId = R.string.plan,
        titleTextId = R.string.plan,
    ),
    THIRD(
        selectedIcon = ImageVectorIcon(RapimoIcon.Home),
        unselectedIcon = ImageVectorIcon(RapimoIcon.Home), // should use home border
        iconTextId = R.string.home,
        titleTextId = R.string.home,
    ),
}