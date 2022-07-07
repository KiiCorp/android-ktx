package com.kii.cloud.storage.ktx

import com.kii.cloud.storage.KiiServerCodeEntry
import com.kii.cloud.storage.KiiServerCodeEntryArgument
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

suspend fun KiiServerCodeEntry.executeAsync(
    argument: KiiServerCodeEntryArgument,
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    execute(argument)
}