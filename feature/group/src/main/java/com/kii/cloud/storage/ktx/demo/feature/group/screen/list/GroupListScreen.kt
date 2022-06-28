package com.kii.cloud.storage.ktx.demo.feature.group.screen.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kii.cloud.storage.KiiGroup

private val loadingList = listOf(KiiGroup.groupWithID("loading"))

@Composable
fun GroupOfMemberScreen(viewModel: GroupOfMemberViewModel) {
    val list by viewModel.groups.collectAsState(loadingList)
    GroupListScreen(list)
}

@Composable
fun GroupOfOwnerScreen(viewModel: GroupOfOwnerViewModel) {
    val list by viewModel.groups.collectAsState(loadingList)
    GroupListScreen(list)
}

@Composable
fun GroupListScreen(groups: List<KiiGroup>) {
    if (groups === loadingList) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            CircularProgressIndicator(
                modifier = Modifier.size(48.dp)
            )
        }
        return
    }

    if (groups.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Text("Empty!")
        }
        return
    }
    LazyColumn {
        items(groups) { group ->
            ListGroupItem(group)
        }
    }
}

@Composable
fun ListGroupItem(group: KiiGroup) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        contentAlignment = Alignment.CenterStart,
    ) {
        Text(
            group.groupName ?: "",
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}
