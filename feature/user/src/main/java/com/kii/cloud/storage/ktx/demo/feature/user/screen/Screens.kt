package com.kii.cloud.storage.ktx.demo.feature.user.screen

sealed class Screens(val route: String) {
    object Top : Screens("users/top")
    object FindUserByUsername : Screens("users/find/username")
    object FindUserByEmail : Screens("users/find/email")
    object FindUserByPhone : Screens("users/find/phone")
}
