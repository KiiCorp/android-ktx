package com.kii.cloud.storage.ktx

import com.kii.cloud.storage.KiiBucket
import com.kii.cloud.storage.KiiPushSubscription
import com.kii.cloud.storage.KiiSubscribable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

suspend fun KiiPushSubscription.subscribeBucketAsync(
    bucket: KiiBucket,
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    subscribeBucket(bucket)
}

suspend fun KiiPushSubscription.unsubscribeBucketAsync(
    bucket: KiiBucket,
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    unsubscribeBucket(bucket)
}

suspend fun KiiPushSubscription.subscribeAsync(
    target: KiiSubscribable,
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    subscribe(target)
}

suspend fun KiiPushSubscription.unsubscribeAsync(
    target: KiiSubscribable,
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    unsubscribe(target)
}

suspend fun KiiPushSubscription.isSubscribedAsync(
    target: KiiSubscribable,
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    isSubscribed(target)
}