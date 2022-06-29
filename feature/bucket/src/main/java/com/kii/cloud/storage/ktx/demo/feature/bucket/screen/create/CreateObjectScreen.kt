package com.kii.cloud.storage.ktx.demo.feature.bucket.screen.create

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier

@Composable
fun CreateObjectScreen(
    viewModel: CreateObjectViewModel,
    back: () -> Unit
) {
    val inProgress by viewModel.inProgress.collectAsState()
    val done by viewModel.done.collectAsState()

    CreateObjectScreen(
        done = done,
        inProgress = inProgress,
        create = {
            viewModel.create()
        },
        back = back,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateObjectScreen(
    done: Boolean,
    inProgress: Boolean,
    create: () -> Unit,
    back: () -> Unit,
) {
    LaunchedEffect(done) {
        if (done) {
            back()
        }
    }
    if (done) {
        return
    }
    Scaffold { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues),
        ) {
            item {
                Button(
                    enabled = !inProgress,
                    onClick = { create() }
                ) {
                    Text("Create")
                }
            }
        }
    }
}