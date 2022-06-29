package com.kii.cloud.storage.ktx.demo.feature.bucket.screen.name

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BucketNameScreen(done: (name: String) -> Unit) {
    var name by remember { mutableStateOf("") }
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth()
        ) {
            OutlinedTextField(
                label = { Text("Bucket name") },
                value = name, onValueChange = { name = it },
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
            Button(
                modifier = Modifier.padding(horizontal = 16.dp),
                onClick = {
                    if (name.trim().isEmpty()) return@Button
                    done(name.trim())
                }) {
                Text("OK")
            }
        }
    }
}