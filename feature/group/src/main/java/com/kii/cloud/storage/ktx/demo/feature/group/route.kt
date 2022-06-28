package com.kii.cloud.storage.ktx.demo.feature.group

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.kii.cloud.storage.ktx.demo.feature.group.screen.GroupTopScreen
import com.kii.cloud.storage.ktx.demo.feature.group.screen.Screens
import com.kii.cloud.storage.ktx.demo.feature.group.screen.list.GroupOfMemberScreen
import com.kii.cloud.storage.ktx.demo.feature.group.screen.list.GroupOfMemberViewModel
import com.kii.cloud.storage.ktx.demo.feature.group.screen.list.GroupOfOwnerScreen
import com.kii.cloud.storage.ktx.demo.feature.group.screen.list.GroupOfOwnerViewModel

fun NavGraphBuilder.groupGraph(navController: NavController) {
    navigation(startDestination = Screens.Top.route, route = "groups") {
        composable(Screens.Top.route) {
            GroupTopScreen {
                navController.navigate(it)
            }
        }
        composable(Screens.JoinedAsMember.route) {
            val vm: GroupOfMemberViewModel = hiltViewModel()
            GroupOfMemberScreen(vm)
        }
        composable(Screens.JoinedAsOwner.route) {
            val vm: GroupOfOwnerViewModel = hiltViewModel()
            GroupOfOwnerScreen(vm)
        }
    }
}