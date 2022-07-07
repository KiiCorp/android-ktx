package com.kii.cloud.storage.ktx

import com.kii.cloud.storage.KiiPushMessage
import com.kii.cloud.storage.KiiTopic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

suspend fun KiiTopic.existsAsync(
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    exists()
}

suspend fun KiiTopic.saveAsync(
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    save()
}

suspend fun KiiTopic.sendMessageAsync(
    message: KiiPushMessage,
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    sendMessage(message)
}

suspend fun KiiTopic.deleteAsync(
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    delete()
}