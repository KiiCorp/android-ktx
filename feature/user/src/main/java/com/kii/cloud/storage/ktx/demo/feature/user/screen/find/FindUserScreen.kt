package com.kii.cloud.storage.ktx.demo.feature.user.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kii.cloud.storage.ktx.demo.feature.user.screen.find.FindUserByEmailViewModel
import com.kii.cloud.storage.ktx.demo.feature.user.screen.find.FindUserByPhoneViewModel
import com.kii.cloud.storage.ktx.demo.feature.user.screen.find.FindUserByUsernameViewModel

@Composable
fun FindUserByUsernameScreen(viewModel: FindUserByUsernameViewModel) {
    val inProgress by viewModel.inProgress.collectAsState()
    FindUserScreen(
        "username",
        inProgress = inProgress,
    ) { username ->
        viewModel.find(username)
    }
}

@Composable
fun FindUserByEmailScreen(viewModel: FindUserByEmailViewModel) {
    val inProgress by viewModel.inProgress.collectAsState()
    FindUserScreen(
        "email",
        inProgress = inProgress,
    ) { username ->
        viewModel.find(username)
    }
}

@Composable
fun FindUserByPhoneScreen(viewModel: FindUserByPhoneViewModel) {
    val inProgress by viewModel.inProgress.collectAsState()
    FindUserScreen(
        "phone",
        inProgress = inProgress,
    ) { username ->
        viewModel.find(username)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FindUserScreen(
    label: String,
    inProgress: Boolean,
    search: (identifier: String) -> Unit,
) {
    var username by remember { mutableStateOf("") }

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth()
        ) {
            OutlinedTextField(
                label = {
                    Text(label)
                },
                value = username, onValueChange = { username = it },
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 16.dp)
                    .fillMaxWidth()
            )
            Button(
                enabled = !inProgress,
                onClick = {
                    search(username)
                },
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Text("Search")
            }
        }
    }
}

@Composable
@Preview
fun PreviewFindUserScreen() {
    FindUserByUsernameScreen(viewModel())
}