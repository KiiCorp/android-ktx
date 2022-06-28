package com.kii.cloud.storage.ktx.demo.feature.group.screen

import androidx.compose.runtime.Composable
import com.kii.cloud.storage.ktx.demo.core.ui.menu.MenuItem
import com.kii.cloud.storage.ktx.demo.core.ui.menu.MenuScreen

@Composable
fun GroupTopScreen(navigate: (route: String) -> Unit) {
    MenuScreen(
        menuItems = listOf(
            MenuItem(
                text = "List as member",
                icon = android.R.drawable.ic_menu_search,
                route = Screens.JoinedAsMember.route,
            ),
            MenuItem(
                text = "List as owner",
                icon = android.R.drawable.ic_menu_search,
                route = Screens.JoinedAsOwner.route,
            ),
        ), navigate = navigate
    )
}

