package com.kii.cloud.storage.ktx

import com.kii.cloud.storage.KiiObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import kotlin.coroutines.CoroutineContext

suspend fun KiiObject.saveAsync(
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    save()
}

suspend fun KiiObject.saveAsync(
    overWrite: Boolean,
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    save(overWrite)
}

suspend fun KiiObject.saveAllFieldsAsync(
    overWrite: Boolean,
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    saveAllFields(overWrite)
}

suspend fun KiiObject.deleteAsync(
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    delete()
}

suspend fun KiiObject.publishBodyAsync(
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    publishBody()
}

suspend fun KiiObject.publishBodyExpiresAtAsync(
    expiresAt: Long,
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    publishBodyExpiresAt(expiresAt)
}

suspend fun KiiObject.publishBodyExpiresInAsync(
    expiresIn: Int,
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    publishBodyExpiresIn(expiresIn)
}

suspend fun KiiObject.uploadBodyAsync(
    sourceFile: File,
    contentType: String?,
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    uploadBody(sourceFile, contentType)
}

suspend fun KiiObject.downloadBodyAsync(
    destFile: File,
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    downloadBody(destFile)
}

suspend fun KiiObject.deleteBodyAsync(
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    deleteBody()
}

suspend fun KiiObject.refreshAsync(
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    refresh()
}
