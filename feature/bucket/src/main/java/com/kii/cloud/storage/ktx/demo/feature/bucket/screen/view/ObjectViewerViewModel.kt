package com.kii.cloud.storage.ktx.demo.feature.bucket.screen.view

import androidx.core.net.toUri
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.kii.cloud.storage.KiiObject
import com.kii.cloud.storage.ktx.refreshAsync
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class ObjectViewerViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val obj = flow {
        val objectURI = savedStateHandle.get<String>("objectURI") ?: ""
        val kiiObj = KiiObject.createByUri(objectURI.toUri())
        kiiObj.refreshAsync()
        emit(kiiObj)
    }
}
