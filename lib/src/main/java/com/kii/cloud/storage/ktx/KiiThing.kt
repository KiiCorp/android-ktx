package com.kii.cloud.storage.ktx

import com.kii.cloud.storage.KiiThing
import com.kii.cloud.storage.KiiThingOwner
import com.kii.cloud.storage.ThingFields
import com.kii.cloud.storage.query.KiiThingQuery
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class KiiThingKTX {
    companion object {
        suspend fun registerOwnerWithThingIDAsync(
            thingID: String,
            owner: KiiThingOwner,
            password: String,
            context: CoroutineContext = Dispatchers.IO,
        ) = withContext(context) {
            @Suppress("BlockingMethodInNonBlockingContext")
            KiiThing.registerOwnerWithThingID(thingID, owner, password)
        }

        suspend fun registerOwnerWithVendorThingIDAsync(
            thingID: String,
            owner: KiiThingOwner,
            password: String,
            context: CoroutineContext = Dispatchers.IO,
        ) = withContext(context) {
            @Suppress("BlockingMethodInNonBlockingContext")
            KiiThing.registerOwnerWithVendorThingID(thingID, owner, password)
        }

        suspend fun registerAsync(
            vendorThingID: String,
            password: String,
            thingType: String?,
            thingFields: ThingFields?,
            context: CoroutineContext = Dispatchers.IO,
        ) = withContext(context) {
            @Suppress("BlockingMethodInNonBlockingContext")
            KiiThing.register(vendorThingID, password, thingType, thingFields)
        }

        suspend fun loadWithThingIDAsync(
            thingId: String,
            context: CoroutineContext = Dispatchers.IO,
        ) = withContext(context) {
            @Suppress("BlockingMethodInNonBlockingContext")
            KiiThing.loadWithThingID(thingId)
        }

        suspend fun loadWithVendorThingIDAsync(
            vendorThingID: String,
            context: CoroutineContext = Dispatchers.IO,
        ) = withContext(context) {
            @Suppress("BlockingMethodInNonBlockingContext")
            KiiThing.loadWithVendorThingID(vendorThingID)
        }

        suspend fun queryAsync(
            query: KiiThingQuery,
            context: CoroutineContext = Dispatchers.IO,
        ) = withContext(context) {
            @Suppress("BlockingMethodInNonBlockingContext")
            KiiThing.query(query)
        }
    }
}

suspend fun KiiThing.refreshAsync(
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    refresh()
}

suspend fun KiiThing.updateAsync(
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    update()
}

suspend fun KiiThing.deleteAsync(
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    delete()
}

suspend fun KiiThing.isOwnerAsync(
    owner: KiiThingOwner,
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    isOwner(owner)
}

suspend fun KiiThing.registerOwnerAsync(
    owner: KiiThingOwner,
    password: String,
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    registerOwner(owner, password)
}

suspend fun KiiThing.unregisterOwnerAsync(
    owner: KiiThingOwner,
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    unregisterOwner(owner)
}

suspend fun KiiThing.disableAsync(
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    disable()
}

suspend fun KiiThing.enableAsync(
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    enable()
}

suspend fun KiiThing.listTopicsAsync(
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    listTopics(null)
}


suspend fun KiiThing.listTopicsAsync(
    paginationKey: String,
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    listTopics(paginationKey)
}



