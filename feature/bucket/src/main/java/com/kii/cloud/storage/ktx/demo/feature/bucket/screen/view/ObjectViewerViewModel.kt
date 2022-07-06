package com.kii.cloud.storage.ktx.demo.feature.bucket.screen.view

import androidx.core.net.toUri
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kii.cloud.storage.KiiObject
import com.kii.cloud.storage.ktx.refreshAsync
import com.kii.cloud.storage.ktx.saveAsync
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ObjectViewerViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val showEditDialog = MutableStateFlow(false)
    val editKey = MutableStateFlow("")
    val editValueType = MutableStateFlow(2)
    val editValueExpanded = MutableStateFlow(false)
    val editValue = MutableStateFlow("")

    val inProgress = MutableStateFlow(false)
    val done = MutableStateFlow(false)

    val obj = flow {
        val objectURI = savedStateHandle.get<String>("objectURI") ?: ""
        val kiiObj = KiiObject.createByUri(objectURI.toUri())
        kiiObj.refreshAsync()
        emit(kiiObj)
    }

    fun openEditDialog(key: String, valueType: Int, value: String) {
        if (inProgress.value) return

        showEditDialog.value = true
        editKey.value = key
        editValueType.value = valueType
        editValueExpanded.value = false
        editValue.value = value
    }

    fun closeEditDialog() {
        showEditDialog.value = false
    }

    fun setEditValueType(type: Int) {
        val value = editValue.value
        editValueType.value = type
        editValueExpanded.value = false
        when (type) {
            1 -> {
                try {
                    value.toInt()
                } catch (e: Exception) {
                    editValue.value = ""
                }
            }
        }
    }

    fun submitEdit(obj: KiiObject) {
        val key = editKey.value
        val valueType = editValueType.value
        val value = editValue.value
        when (valueType) {
            1 -> {
                val intVal = try {
                    value.toInt()
                } catch (e: Exception) {
                    return
                }
                obj.set(key, intVal)
                showEditDialog.value = false
            }
            2 -> {
                obj.set(key, value)
                showEditDialog.value = false
            }
        }
    }

    fun save(obj: KiiObject) {
        viewModelScope.launch {
            try {
                inProgress.value = true
                obj.saveAsync()
                done.value = true
            } catch (e: Exception) {

            } finally {
                inProgress.value = false
            }
        }
    }


}
