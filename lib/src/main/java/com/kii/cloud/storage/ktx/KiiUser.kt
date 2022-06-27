package com.kii.cloud.storage.ktx

import com.kii.cloud.storage.IdentityData
import com.kii.cloud.storage.KiiUser
import com.kii.cloud.storage.KiiUser.registerAsPseudoUser
import com.kii.cloud.storage.UserFields
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

object KiiUserKTX {
    suspend fun loginAsync(
        userIdentifier: String,
        password: String,
        context: CoroutineContext = Dispatchers.IO,
    ) = withContext(context) {
        @Suppress("BlockingMethodInNonBlockingContext")
        KiiUser.logIn(userIdentifier, password)
    }

    suspend fun logInWithLocalPhoneAsync(
        localPhoneNumber: String,
        password: String,
        country: String,
        context: CoroutineContext = Dispatchers.IO,
    ) = withContext(context) {
        @Suppress("BlockingMethodInNonBlockingContext")
        KiiUser.logInWithLocalPhone(localPhoneNumber, password, country)
    }

    suspend fun loginWithTokenAsync(
        token: String,
        context: CoroutineContext = Dispatchers.IO,
    ) = withContext(context) {
        @Suppress("BlockingMethodInNonBlockingContext")
        KiiUser.loginWithToken(token)
    }

    suspend fun loginWithTokenAsync(
        token: String,
        expireAt: Long,
        context: CoroutineContext = Dispatchers.IO,
    ) = withContext(context) {
        @Suppress("BlockingMethodInNonBlockingContext")
        KiiUser.loginWithToken(token, expireAt)
    }

    suspend fun loginWithTokenAsync(
        token: String,
        expireAt: Long,
        refreshToken: String,
        context: CoroutineContext = Dispatchers.IO,
    ) = withContext(context) {
        @Suppress("BlockingMethodInNonBlockingContext")
        KiiUser.loginWithToken(token, expireAt, refreshToken)
    }

    suspend fun resetPasswordAsync(
        identifier: String,
        context: CoroutineContext = Dispatchers.IO,
    ) = withContext(context) {
        @Suppress("BlockingMethodInNonBlockingContext")
        KiiUser.resetPassword(identifier)
    }

    suspend fun resetPasswordAsync(
        identifier: String,
        notificationMethod: KiiUser.NotificationMethod,
        context: CoroutineContext = Dispatchers.IO,
    ) = withContext(context) {
        @Suppress("BlockingMethodInNonBlockingContext")
        KiiUser.resetPassword(identifier, notificationMethod)
    }

    suspend fun completeResetPasswordAsync(
        identifier: String,
        pinCode: String,
        newPassword: String?,
        context: CoroutineContext = Dispatchers.IO,
    ) = withContext(context) {
        @Suppress("BlockingMethodInNonBlockingContext")
        KiiUser.completeResetPassword(identifier, pinCode, newPassword)
    }

    suspend fun changePhoneAsync(
        phoneNumber: String,
        context: CoroutineContext = Dispatchers.IO,
    ) = withContext(context) {
        @Suppress("BlockingMethodInNonBlockingContext")
        KiiUser.changePhone(phoneNumber)
    }

    suspend fun changeEmailAsync(
        email: String,
        context: CoroutineContext = Dispatchers.IO,
    ) = withContext(context) {
        @Suppress("BlockingMethodInNonBlockingContext")
        KiiUser.changeEmail(email)
    }

    suspend fun requestResendPhoneVerificationCodeAsync(
        context: CoroutineContext = Dispatchers.IO,
    ) = withContext(context) {
        @Suppress("BlockingMethodInNonBlockingContext")
        KiiUser.requestResendPhoneVerificationCode()
    }

    suspend fun requestResendEmailVerificationAsync(
        context: CoroutineContext = Dispatchers.IO,
    ) = withContext(context) {
        @Suppress("BlockingMethodInNonBlockingContext")
        KiiUser.requestResendEmailVerification()
    }

    suspend fun findUserByEmailAsync(
        email: String,
        context: CoroutineContext = Dispatchers.IO,
    ) = withContext(context) {
        @Suppress("BlockingMethodInNonBlockingContext")
        KiiUser.findUserByEmail(email)
    }

    suspend fun findUserByPhoneAsync(
        phone: String,
        context: CoroutineContext = Dispatchers.IO,
    ) = withContext(context) {
        @Suppress("BlockingMethodInNonBlockingContext")
        KiiUser.findUserByPhone(phone)
    }

    suspend fun findUserByUserNameAsync(
        username: String,
        context: CoroutineContext = Dispatchers.IO,
    ) = withContext(context) {
        @Suppress("BlockingMethodInNonBlockingContext")
        KiiUser.findUserByUserName(username)
    }
}


suspend fun KiiUser.changePasswordAsync(
    newPassword: String,
    oldPassword: String,
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    changePassword(newPassword, oldPassword)
}

suspend fun KiiUser.registerAsync(
    password: String,
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    register(password)
}

suspend fun KiiUser.registerAsPseudoUserAsync(
    userFields: UserFields?,
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    registerAsPseudoUser(userFields)
}

suspend fun KiiUser.putIdentityAsync(
    identityData: IdentityData,
    userFields: UserFields?,
    password: String,
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    putIdentity(identityData, userFields, password)
}

suspend fun KiiUser.updateAsync(
    userFields: UserFields,
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    update(userFields)
}

suspend fun KiiUser.updateAsync(
    identityData: IdentityData?,
    userFields: UserFields,
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    update(identityData, userFields)
}


suspend fun KiiUser.deleteAsync(
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    delete()
}

suspend fun KiiUser.refreshAsync(
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    refresh()
}

suspend fun KiiUser.verifyPhoneAsync(
    code: String,
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    verifyPhone(code)
}

suspend fun KiiUser.memberOfGroupsAsync(
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    memberOfGroups()
}

suspend fun KiiUser.ownerOfGroupsAsync(
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    ownerOfGroups()
}


suspend fun KiiUser.listTopics(
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    listTopics()
}

suspend fun KiiUser.listTopics(
    paginationKey: String,
    context: CoroutineContext = Dispatchers.IO,
) = withContext(context) {
    @Suppress("BlockingMethodInNonBlockingContext")
    listTopics(paginationKey)
}



