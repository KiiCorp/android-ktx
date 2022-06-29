package com.kii.cloud.storage.ktx.demo.feature.bucket.screen

import java.net.URLEncoder
import java.nio.charset.StandardCharsets

sealed class Screens(val route: String) {
    object AppBucketName : Screens("appBuckets")
    object ObjectViewer : Screens("objects/{objectURI}") {
        fun makeRoute(uri: String): String {
            val encodedUri = URLEncoder.encode(uri, StandardCharsets.UTF_8.toString())
            return "objects/${encodedUri}"
        }
    }
}
