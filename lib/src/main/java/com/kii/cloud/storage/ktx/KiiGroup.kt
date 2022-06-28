package com.kii.cloud.storage.ktx

import com.kii.cloud.storage.KiiGroup
import com.kii.cloud.storage.KiiUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

object KiiGroupKTX {
    suspend fun registerGroupWithID(
        id: String,
        name: String,
        members: List<KiiUser>,
        context: CoroutineContext = Dispatchers.IO,
    ) = withContext(context) {
        @Suppress("BlockingMethodInNonBlockingContext")
        KiiGroup.registerGroupWithID(id, name, members)
    }
}

suspend fun KiiGroup.getOwnerAsync(
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    owner
}

suspend fun KiiGroup.listMembersAsync(
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    listMembers()
}

suspend fun KiiGroup.refreshAsync(
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    refresh()
}

suspend fun KiiGroup.changeNameAsync(
    name: String,
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    changeName(name)
}

suspend fun KiiGroup.saveAsync(
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    save()
}

suspend fun KiiGroup.deleteAsync(
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    delete()
}

suspend fun KiiGroup.listTopicsAsync(
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    listTopics()
}

suspend fun KiiGroup.listTopicsAsync(
    paginationKey: String,
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    listTopics(paginationKey)
}


