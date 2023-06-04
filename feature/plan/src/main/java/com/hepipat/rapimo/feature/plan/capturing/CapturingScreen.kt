package com.hepipat.rapimo.feature.plan

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hepipat.rapimo.core.designsystem.component.RapimoTopAppBar
import com.hepipat.rapimo.core.designsystem.icon.RapimoIcon
import com.hepipat.rapimo.feature.plan.capturing.CapturingViewModel

@Composable
internal fun CapturingRoute(
    onBackClick: () -> Unit,
    //other onclicks,
    modifier: Modifier = Modifier,
    /*viewModel: CapturingViewModel = hiltViewModel(),*/
) {
    val capturingList = remember {
        mutableStateListOf("test1", "test2", "test3", "test4", "test5", "test6")
    }
    CapturingScreen(
        capturingList = capturingList,
        modifier = modifier,
        onSendClicked = { capturingList.add(it) },
        onBackClick = onBackClick
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun CapturingScreen(
    capturingList: List<String>, //should be used ui state to handle loading and empty list
    onSendClicked: (String) -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier
) {
    Column {
        RapimoTopAppBar(
            titleRes = androidx.appcompat.R.string.abc_action_bar_home_description,
            navigationIcon = RapimoIcon.Back,
            navigationIconContentDescription = "Go back",
            onNavigationClick = onBackClick,
            actionIcon = RapimoIcon.Home,
            actionIconContentDescription = ""
        )
        StepPlanningContent(modifier = modifier)
        CapturingList(list = capturingList, modifier = modifier.weight(1f))
        CapturingTextInput(modifier = modifier, onSendClicked)
    }
}

@Composable
fun StepPlanningContent(
    modifier: Modifier,
) {
    Row(modifier = modifier) {
        IconButton(onClick = {  }, modifier = Modifier
            .weight(1f)
            .background(MaterialTheme.colorScheme.surfaceVariant)) {
            Icon(
                imageVector = RapimoIcon.Home,
                contentDescription = "",
                tint = MaterialTheme.colorScheme.onSurface,
            )
        }
        Icon(
            imageVector = RapimoIcon.Forward,
            contentDescription = "",
            tint = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        IconButton(onClick = {  }, modifier = Modifier.weight(1f)) {
            Icon(
                imageVector = RapimoIcon.Home,
                contentDescription = "",
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
        Icon(
            imageVector = RapimoIcon.Forward,
            contentDescription = "",
            tint = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        IconButton(onClick = {  }, modifier = Modifier.weight(1f)) {
            Icon(
                imageVector = RapimoIcon.Home,
                contentDescription = "",
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
        Icon(
            imageVector = RapimoIcon.Forward,
            contentDescription = "",
            tint = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        IconButton(onClick = {  }, modifier = Modifier.weight(1f)) {
            Icon(
                imageVector = RapimoIcon.Home,
                contentDescription = "",
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Composable
fun CapturingList(
    list: List<String>,
    //onclicks
    modifier: Modifier,
) {
    LazyColumn(
        modifier = modifier
            .padding(horizontal = 16.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        list.forEach { item ->
            item(item + (1..1000).random()) {
                CapturingListItem(
                    actionTitle = item,
                    modifier = modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun CapturingListItem(
    actionTitle: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Text(
            text = actionTitle,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CapturingTextInput(modifier: Modifier, onSendClicked: (String) -> Unit) {
    var testString by rememberSaveable { mutableStateOf("") }

    Column(verticalArrangement = Arrangement.Bottom, modifier = modifier) {
        Text(text = testString, modifier = modifier
            .padding(10.dp)
            .align(Alignment.CenterHorizontally))
        TextField(
            value = testString,
            onValueChange = { testString = it },
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
            trailingIcon = { Icon(imageVector = RapimoIcon.Capture, contentDescription = "Add actions", modifier = modifier.clickable { onSendClicked(testString) })},
            maxLines = 4,
            placeholder = { Text(text = "Write down your actions...") },
            modifier = Modifier
                .fillMaxWidth()
        )
        /*Button(
            modifier = Modifier.height(36.dp),
            //enabled = sendMessageEnabled,
            onClick = { onSendClicked(testString) },
            //colors = buttonColors,
            //border = border,
            contentPadding = PaddingValues(0.dp)
        ) {
            Text(
                stringResource(id = androidx.compose.ui.R.string.on),
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }*/
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_2, showSystemUi = true)
@Composable
fun CapturingScreenPreview() {
    CapturingScreen(capturingList = listOf("test1", "test2", "test3", "test4", "test5", "test1", "test2", "test3", "test4", "test5"), {}, {}, modifier = Modifier)
}