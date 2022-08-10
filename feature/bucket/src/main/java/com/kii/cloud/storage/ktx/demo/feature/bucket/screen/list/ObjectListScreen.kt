package com.kii.cloud.storage.ktx.demo.feature.bucket.screen.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.kii.cloud.storage.KiiBucket
import com.kii.cloud.storage.KiiObject

private val loadingList = listOf(
    KiiObject.createByUri("kiicloud://buckets/loading/objects/1".toUri())
)

@Composable
fun ObjectListScreen(
    viewModel: ObjectListViewModel,
    toAdd: () -> Unit,
    toACL: () -> Unit,
    toObjectDetail: (obj: KiiObject) -> Unit,
) {
    val list by viewModel.objectList.collectAsState(loadingList)
    ObjectListScreen(
        bucket = viewModel.getBucket(),
        list = list,
        toAdd = toAdd,
        toACL = toACL,
        toObjectDetail = toObjectDetail,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ObjectListScreen(
    bucket: KiiBucket,
    list: List<KiiObject>,
    toAdd: () -> Unit,
    toACL: () -> Unit,
    toObjectDetail: (obj: KiiObject) -> Unit,
) {
    var menuExpanded by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {
                    Text(bucket.name)
                },
                actions = {
                    IconButton(onClick = { menuExpanded = !menuExpanded }) {
                        Icon(imageVector = Icons.Default.MoreVert, contentDescription = "")
                    }
                    DropdownMenu(expanded = menuExpanded,
                        onDismissRequest = { menuExpanded = !menuExpanded }
                    ) {
                        DropdownMenuItem(
                            text = {
                                Text("ACL")
                            }, onClick = toACL
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            if (list !== loadingList) {
                LargeFloatingActionButton(onClick = toAdd) {
                    Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
                }
            }
        }
    ) { paddingValues ->
        if (list === loadingList) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center,
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(48.dp)
                )
            }
            return@Scaffold
        }
        if (list.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center,
            ) {
                Text("Empty bucket!")
            }
            return@Scaffold
        }

        LazyColumn(
            modifier = Modifier.padding(paddingValues)
        ) {
            items(list) { obj ->
                ObjectListItem(obj, toObjectDetail)
            }
        }
    }
}

@Composable
fun ObjectListItem(
    obj: KiiObject,
    onClick: (obj: KiiObject) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .clickable {
                onClick(obj)
            },
        contentAlignment = Alignment.CenterStart,
    ) {
        Text(
            text = obj.toUri()?.toString() ?: "",
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Divider(modifier = Modifier.offset(y = 31.dp))
    }
}
