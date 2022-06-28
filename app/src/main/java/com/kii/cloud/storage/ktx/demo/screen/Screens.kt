package com.kii.cloud.storage.ktx.demo.screen

sealed class Screens(val route: String) {
    object Main : Screens("main")
    object Login : Screens("login")
    object Users : Screens("users")
}
