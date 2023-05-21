package com.hepipat.rapimo.feature.plan

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun PlanRoute(
    onStartClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    PlanScreen(onStartClick = onStartClick, modifier = modifier)
}

@Composable
fun PlanScreen(
    onStartClick: () -> Unit,
    modifier: Modifier
) {
    Column {
        PlanStartDefault(onStartClick = onStartClick, modifier = modifier) {
            Button(onClick = onStartClick) {
                Text(text = "Create new plan")
            }
        }
        PlanHistory(modifier = modifier)
    }
}

@Composable
fun PlanStartDefault(
    onStartClick: () -> Unit,
    modifier: Modifier,
    content: @Composable () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f)
    ) {
        content()
    }
}

@Composable
fun PlanHistory(modifier: Modifier) {
    Column (
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f)
            .padding(16.dp)
    ){
        Text(text = "History")
    }
}
