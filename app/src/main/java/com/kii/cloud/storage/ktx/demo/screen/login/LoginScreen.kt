package com.kii.cloud.storage.ktx.demo.screen.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kii.cloud.storage.ktx.ui.theme.AndroidStorageSDKktxDemoTheme

@Composable
fun LoginScreen(
    vm: LoginViewModel,
    back: () -> Unit,
) {
    val inProgress by vm.inProgress.collectAsState()
    val done by vm.done.collectAsState()

    LoginScreen(
        inProgress = inProgress,
        done = done,
        back = back,
        login = { username, password -> vm.login(username, password) },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    inProgress: Boolean,
    done: Boolean,
    back: () -> Unit,
    login: (username: String, password: String) -> Unit
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    LaunchedEffect(done) {
        if (done) {
            back()
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .width(200.dp)
                    .padding(top = 16.dp),
                label = {
                    Text("Username")
                },
                value = username,
                onValueChange = { username = it },
            )
            OutlinedTextField(
                modifier = Modifier
                    .width(200.dp)
                    .padding(top = 16.dp),
                label = {
                    Text("Password")
                },
                value = password,
                onValueChange = { password = it },
            )
            Button(
                modifier = Modifier.padding(top = 16.dp),
                enabled = !inProgress,
                onClick = {
                    login(username, password)
                }
            ) {
                Text("Log in")
            }
        }
    }
}

@Composable
@Preview
fun PreviewLoginScreen() {
    AndroidStorageSDKktxDemoTheme {
        LoginScreen(viewModel()) { }
    }
}