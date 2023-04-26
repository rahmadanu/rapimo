package com.hepipat.rapimo.core.designsystem.icon

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

object RapimoIcon {
    val Home = Icons.Default.Home
}

sealed class Icon {
    data class ImageVectorIcon(val imageVector: ImageVector): Icon()
    data class DrawableResourceIcon(@DrawableRes val id: Int): Icon()
}