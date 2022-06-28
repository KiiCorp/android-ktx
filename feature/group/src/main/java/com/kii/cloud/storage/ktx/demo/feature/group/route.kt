package com.kii.cloud.storage.ktx.demo.feature.group

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.kii.cloud.storage.ktx.demo.feature.group.screen.GroupTopScreen
import com.kii.cloud.storage.ktx.demo.feature.group.screen.Screens

fun NavGraphBuilder.groupGraph(navController: NavController) {
    navigation(startDestination = Screens.Top.route, route = "groups") {
        composable(Screens.Top.route) {
            GroupTopScreen {
                navController.navigate(it)
            }
        }
    }
}