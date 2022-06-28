package com.kii.cloud.storage.ktx.demo

import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kii.cloud.storage.KiiUser
import com.kii.cloud.storage.ktx.demo.feature.user.userGraph
import com.kii.cloud.storage.ktx.demo.screen.Screens
import com.kii.cloud.storage.ktx.demo.screen.login.LoginScreen
import com.kii.cloud.storage.ktx.demo.screen.login.LoginViewModel
import com.kii.cloud.storage.ktx.demo.screen.main.MainScreen

@Composable
fun DemoApp() {
    var initialized by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        try {
            KiiUser.loginWithStoredCredentials()
        } catch (e: Exception) {

        } finally {
            initialized = true
        }
    }
    if (initialized) {
        DemoAppMain()
    }
}

@Composable
fun DemoAppMain() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.Main.route) {
        composable(Screens.Main.route) {
            MainScreen(
                navigate = {
                    navController.navigate(it)
                },
                toLogin = {
                    navController.navigate(Screens.Login.route)
                },
            )
        }
        composable(Screens.Login.route) {
            val vm: LoginViewModel = hiltViewModel()
            LoginScreen(vm) {
                navController.popBackStack()
            }
        }
        userGraph(navController)
    }
}