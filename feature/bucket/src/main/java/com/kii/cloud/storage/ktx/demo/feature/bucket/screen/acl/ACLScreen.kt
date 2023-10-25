package com.kii.cloud.storage.ktx.demo.feature.bucket.screen.acl

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.kii.cloud.storage.KiiACLEntry


@Composable
fun ACLScreen(
    viewModel: ACLViewModel,
    back: () -> Unit,
) {
    val aclEntries by viewModel.aclEntries.collectAsState(emptyList())
    val isUnauthorized by viewModel.isUnauthorized.collectAsState(false)
    ACLScreen(
        isUnauthorized = isUnauthorized,
        list = aclEntries,
        back = back,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ACLScreen(
    isUnauthorized: Boolean,
    list: List<KiiACLEntry>,
    back: () -> Unit,
) {
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {
                    Text("ACL")
                },
                navigationIcon = {
                    IconButton(onClick = back) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                    }
                }
            )
        }
    ) { paddingValues ->
        if (isUnauthorized) {
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Text("Unauthorized")
            }
            return@Scaffold
        }
        LazyColumn(
            modifier = Modifier.padding(paddingValues)
        ) {
            items(list) {
                Text(it.toString())
            }
        }
    }
}