package com.kii.cloud.storage.ktx.demo.feature.group.screen.list

import androidx.lifecycle.ViewModel
import com.kii.cloud.storage.KiiGroup
import com.kii.cloud.storage.KiiUser
import com.kii.cloud.storage.ktx.ownerOfGroupsAsync
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class GroupOfOwnerViewModel @Inject constructor(

) : ViewModel() {
    val groups = flow<List<KiiGroup>> {
        val list = KiiUser.getCurrentUser()?.ownerOfGroupsAsync() ?: return@flow
        this.emit(list)
    }
}