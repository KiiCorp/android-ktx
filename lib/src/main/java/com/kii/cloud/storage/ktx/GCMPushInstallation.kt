package com.kii.cloud.storage.ktx

import com.kii.cloud.storage.GCMPushInstallation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

suspend fun GCMPushInstallation.installAsync(
    registrationId: String,
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    install(registrationId)
}

suspend fun GCMPushInstallation.uninstallAsync(
    registrationId: String,
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    uninstall(registrationId)
}
