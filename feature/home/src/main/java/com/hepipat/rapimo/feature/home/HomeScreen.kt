package com.hepipat.rapimo.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@Composable
internal fun HomeRoute(
    onItemClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    //viewModel
) {
    //collect state/data here

    HomeScreen(
        modifier = modifier,
    )
}

@Composable
fun HomeScreen(modifier: Modifier) {
    Text(text = "Home Screen")
}
