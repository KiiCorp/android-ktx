package com.kii.cloud.storage.ktx.demo.feature.bucket.screen.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.kii.cloud.storage.KiiObject

private val loadingList = listOf(
    KiiObject.createByUri("kiicloud://buckets/loading/objects/1".toUri())
)

@Composable
fun ObjectListScreen(
    viewModel: ObjectListViewModel,
    toAdd: () -> Unit,
    toObjectDetail: (obj: KiiObject) -> Unit,
) {
    val list by viewModel.objectList.collectAsState(loadingList)
    ObjectListScreen(
        list = list,
        toAdd = toAdd,
        toObjectDetail = toObjectDetail,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ObjectListScreen(
    list: List<KiiObject>,
    toAdd: () -> Unit,
    toObjectDetail: (obj: KiiObject) -> Unit,
) {
    Scaffold(
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

        LazyColumn {
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
