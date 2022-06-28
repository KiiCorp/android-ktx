package com.kii.cloud.storage.ktx.demo.feature.group.screen.create

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CreateGroupScreen(viewModel: CreateGroupViewModel, back: () -> Unit) {
    val inProgress by viewModel.inProgress.collectAsState()
    val done by viewModel.done.collectAsState()
    CreateGroupScreen(
        inProgress = inProgress,
        done = done,
        create = { name -> viewModel.create(name) },
        back = back,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CreateGroupScreen(
    inProgress: Boolean,
    done: Boolean,
    create: (name: String) -> Unit,
    back: () -> Unit,
) {
    var name by remember { mutableStateOf("") }

    LaunchedEffect(done) {
        if (done) {
            back()
        }
    }
    if (done) {
        return
    }

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth()
        ) {
            OutlinedTextField(
                value = name, onValueChange = { name = it },
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxWidth()
            )
            Button(
                enabled = !inProgress,
                onClick = {
                    create(name)
                },
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text("Create")
            }
        }
    }
}