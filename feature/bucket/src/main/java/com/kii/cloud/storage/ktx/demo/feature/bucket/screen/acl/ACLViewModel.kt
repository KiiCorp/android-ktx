package com.kii.cloud.storage.ktx.demo.feature.bucket.screen.acl

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kii.cloud.storage.Kii
import com.kii.cloud.storage.KiiACLEntry
import com.kii.cloud.storage.exception.ACLOperationException
import com.kii.cloud.storage.exception.app.UnauthorizedException
import com.kii.cloud.storage.ktx.listACLEntriesAsync
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

abstract class ACLViewModel : ViewModel() {
    val aclEntries = flow {
        try {
            val acl = getACL()
            this.emit(acl.toList())
        } catch (e: ACLOperationException) {
            if (e.cause is UnauthorizedException) {
                isUnauthorized.value = true
            }
        }
    }

    val isUnauthorized = MutableStateFlow(false)

    abstract suspend fun getACL(): Set<KiiACLEntry>
}

@HiltViewModel
class AppBucketACLViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
) : ACLViewModel() {
    override suspend fun getACL(): Set<KiiACLEntry> {
        val name = savedStateHandle.get<String>("name") ?: ""
        return Kii.bucket(name).acl().listACLEntriesAsync()
    }

}