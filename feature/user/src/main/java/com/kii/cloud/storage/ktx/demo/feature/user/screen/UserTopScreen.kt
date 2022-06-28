package com.kii.cloud.storage.ktx.demo.feature.user.screen

import androidx.compose.runtime.Composable
import com.kii.cloud.storage.ktx.demo.core.ui.menu.MenuItem
import com.kii.cloud.storage.ktx.demo.core.ui.menu.MenuScreen

@Composable
fun UserTopScreen(navigate: (route: String) -> Unit) {
    MenuScreen(
        menuItems = listOf(
            MenuItem(
                text = "Find user by username",
                icon = android.R.drawable.ic_menu_search,
                route = Screens.FindUserByUsername.route,
            ),
            MenuItem(
                text = "Find user by email",
                icon = android.R.drawable.ic_menu_search,
                route = Screens.FindUserByEmail.route,
            ),
            MenuItem(
                text = "Find user by phone",
                icon = android.R.drawable.ic_menu_search,
                route = Screens.FindUserByPhone.route,
            )
        ), navigate = navigate
    )
}

