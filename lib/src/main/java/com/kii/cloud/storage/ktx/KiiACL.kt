package com.kii.cloud.storage.ktx

import com.kii.cloud.storage.KiiACL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

suspend fun KiiACL.saveAsync(
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    save()
}

suspend fun KiiACL.listACLEntriesAsync(
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    listACLEntries()
}
