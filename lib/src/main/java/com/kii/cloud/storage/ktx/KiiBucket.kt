package com.kii.cloud.storage.ktx

import com.kii.cloud.storage.KiiBucket
import com.kii.cloud.storage.query.KiiQuery
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

suspend fun KiiBucket.query(
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    query(null)
}

suspend fun KiiBucket.query(
    kiiQuery: KiiQuery,
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    query(kiiQuery)
}

suspend fun KiiBucket.count(
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    count()
}

suspend fun KiiBucket.delete(
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    delete()
}

