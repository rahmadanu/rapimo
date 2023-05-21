package com.hepipat.rapimo.core.designsystem.icon

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.ui.graphics.vector.ImageVector

object RapimoIcon {
    val Home = Icons.Default.Home
    val Capture = Icons.Default.Edit
    val Back = Icons.Default.ArrowBack
    val Forward = Icons.Default.KeyboardArrowRight
}

sealed class Icon {
    data class ImageVectorIcon(val imageVector: ImageVector): Icon()
    data class DrawableResourceIcon(@DrawableRes val id: Int): Icon()
}