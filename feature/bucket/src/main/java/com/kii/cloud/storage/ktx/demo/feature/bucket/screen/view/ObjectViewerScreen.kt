package com.kii.cloud.storage.ktx.demo.feature.bucket.screen.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.net.toUri
import com.kii.cloud.storage.KiiObject

private val loadingObject =
    KiiObject.createByUri("kiicloud://buckets/loading/objects/loading".toUri())

@Composable
fun ObjectViewerScreen(viewModel: ObjectViewerViewModel) {
    val obj by viewModel.obj.collectAsState(loadingObject)
    ObjectViewerScreen(obj = obj)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ObjectViewerScreen(obj: KiiObject) {
    Scaffold { paddingValues ->
        if (obj === loadingObject) {
            return@Scaffold
        }
        Box(modifier = Modifier.padding(paddingValues))
    }
}