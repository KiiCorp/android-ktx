package com.kii.cloud.storage.ktx.demo.feature.bucket

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.kii.cloud.storage.ktx.demo.feature.bucket.screen.Screens
import com.kii.cloud.storage.ktx.demo.feature.bucket.screen.create.AppCreateObjectViewModel
import com.kii.cloud.storage.ktx.demo.feature.bucket.screen.create.CreateObjectScreen
import com.kii.cloud.storage.ktx.demo.feature.bucket.screen.list.AppObjectLitViewModel
import com.kii.cloud.storage.ktx.demo.feature.bucket.screen.list.ObjectListScreen
import com.kii.cloud.storage.ktx.demo.feature.bucket.screen.name.BucketNameScreen
import com.kii.cloud.storage.ktx.demo.feature.bucket.screen.view.ObjectViewerScreen
import com.kii.cloud.storage.ktx.demo.feature.bucket.screen.view.ObjectViewerViewModel

fun NavGraphBuilder.bucketGraph(navController: NavController) {
    composable(Screens.AppBucketName.route) {
        BucketNameScreen { name ->
            navController.navigate("${Screens.AppBucketName.route}/${name}")
        }
    }
    composable("${Screens.AppBucketName.route}/{name}") { backStackEntry ->
        val vm: AppObjectLitViewModel = hiltViewModel()
        ObjectListScreen(
            vm,
            toAdd = {
                val name = backStackEntry.arguments?.getString("name") ?: ""
                navController.navigate("${Screens.AppBucketName.route}/${name}/objects")
            },
            toObjectDetail = { obj ->
                navController.navigate(Screens.ObjectViewer.makeRoute(obj.toUri().toString()))
            }
        )
    }
    composable("${Screens.AppBucketName.route}/{name}/objects") {
        val vm: AppCreateObjectViewModel = hiltViewModel()
        CreateObjectScreen(vm,
            back = {
                navController.popBackStack()
            }
        )
    }
    composable("objects/{objectURI}") {
        val vm: ObjectViewerViewModel = hiltViewModel()
        ObjectViewerScreen(vm) {
            navController.popBackStack()
        }
    }
}