package com.kii.cloud.storage.ktx.demo

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kii.cloud.storage.ktx.demo.screen.Screens
import com.kii.cloud.storage.ktx.demo.screen.login.LoginScreen
import com.kii.cloud.storage.ktx.demo.screen.login.LoginViewModel
import com.kii.cloud.storage.ktx.demo.screen.main.MainScreen

@Composable
fun DemoApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.Main.route) {
        composable(Screens.Main.route) {
            MainScreen {
                navController.navigate(Screens.Login.route)
            }
        }
        composable(Screens.Login.route) {
            val vm: LoginViewModel = hiltViewModel()
            LoginScreen(vm) {
                navController.popBackStack()
            }
        }
    }
}