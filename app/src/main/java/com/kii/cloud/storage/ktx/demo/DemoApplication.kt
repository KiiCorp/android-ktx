package com.kii.cloud.storage.ktx.demo

import android.app.Application
import com.kii.cloud.storage.Kii
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DemoApplication : Application() {
    init {
        Kii.initialize("facb78eb", "e16b62cf6441dbde55e3087e4cf40655", Kii.Site.JP)
    }
}