package com.kii.cloud.storage.ktx.demo.feature.bucket.screen.create

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kii.cloud.storage.Kii
import com.kii.cloud.storage.KiiBucket
import com.kii.cloud.storage.ktx.saveAsync
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

abstract class CreateObjectViewModel : ViewModel() {
    abstract fun getBucket(): KiiBucket

    val inProgress = MutableStateFlow(false)
    val done = MutableStateFlow(false)

    fun create() {
        viewModelScope.launch {
            try {
                inProgress.value = true
                getBucket().`object`().saveAsync()
                done.value = true
            } finally {
                inProgress.value = false
            }
        }
    }
}

@HiltViewModel
class AppCreateObjectViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : CreateObjectViewModel() {
    override fun getBucket(): KiiBucket {
        val name = savedStateHandle.get<String>("name") ?: ""
        return Kii.bucket(name)
    }

}