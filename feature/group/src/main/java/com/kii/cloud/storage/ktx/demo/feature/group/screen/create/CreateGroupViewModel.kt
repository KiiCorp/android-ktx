package com.kii.cloud.storage.ktx.demo.feature.group.screen.create

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kii.cloud.storage.Kii
import com.kii.cloud.storage.ktx.saveAsync
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateGroupViewModel @Inject constructor(

) : ViewModel() {
    val inProgress = MutableStateFlow(false)
    val done = MutableStateFlow(false)

    fun create(groupName: String) {
        viewModelScope.launch {
            try {
                inProgress.value = true
                Kii.group(groupName).saveAsync()
                done.value = true
            } catch (e: Exception) {

            } finally {
                inProgress.value = false
            }
        }
    }
}
