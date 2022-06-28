package com.kii.cloud.storage.ktx.demo.feature.user

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.kii.cloud.storage.ktx.demo.feature.user.screen.*
import com.kii.cloud.storage.ktx.demo.feature.user.screen.find.FindUserByEmailViewModel
import com.kii.cloud.storage.ktx.demo.feature.user.screen.find.FindUserByPhoneViewModel
import com.kii.cloud.storage.ktx.demo.feature.user.screen.find.FindUserByUsernameViewModel

fun NavGraphBuilder.userGraph(navController: NavController) {
    navigation(startDestination = Screens.Top.route, route = "users") {
        composable(Screens.Top.route) {
            UserTopScreen {
                navController.navigate(it)
            }
        }
        composable(Screens.FindUserByUsername.route) {
            val vm: FindUserByUsernameViewModel = hiltViewModel()
            FindUserByUsernameScreen(vm)
        }
        composable(Screens.FindUserByEmail.route) {
            val vm: FindUserByEmailViewModel = hiltViewModel()
            FindUserByEmailScreen(vm)
        }
        composable(Screens.FindUserByPhone.route) {
            val vm: FindUserByPhoneViewModel = hiltViewModel()
            FindUserByPhoneScreen(vm)
        }
    }
}