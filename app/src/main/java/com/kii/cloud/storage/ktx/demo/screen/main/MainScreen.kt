package com.kii.cloud.storage.ktx.demo.screen.main

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.kii.cloud.storage.KiiUser
import com.kii.cloud.storage.ktx.demo.R
import com.kii.cloud.storage.ktx.demo.core.ui.menu.MenuItem
import com.kii.cloud.storage.ktx.demo.core.ui.menu.MenuScreen
import com.kii.cloud.storage.ktx.demo.screen.Screens

@Composable
fun MainScreen(
    navigate: (route: String) -> Unit,
    toLogin: () -> Unit,
) {
    LaunchedEffect(Unit) {
        if (!KiiUser.isLoggedIn()) {
            toLogin()
            return@LaunchedEffect
        }
    }

    MenuScreen(
        menuItems = listOf(
            MenuItem(
                text = "User management",
                icon = R.drawable.ic_baseline_person_24,
                route = Screens.Users.route,
            ),
            MenuItem(
                text = "Group management",
                icon = R.drawable.ic_baseline_group_24,
                route = Screens.Groups.route,
            ),
        ),
        navigate = navigate,
    )
}