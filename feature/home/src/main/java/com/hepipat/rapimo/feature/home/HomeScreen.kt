package com.hepipat.rapimo.feature.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


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
