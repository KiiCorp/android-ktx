package com.kii.cloud.storage.ktx.demo.screen.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.kii.cloud.storage.KiiUser

@Composable
fun MainScreen(toLogin: () -> Unit) {
    LaunchedEffect(Unit) {
        if (!KiiUser.isLoggedIn()) {
            toLogin()
            return@LaunchedEffect
        }
    }
}