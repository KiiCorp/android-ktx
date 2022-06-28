package com.kii.cloud.storage.ktx.demo.screen.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.kii.cloud.storage.KiiUser
import com.kii.cloud.storage.ktx.demo.screen.Screens

@OptIn(ExperimentalMaterial3Api::class)
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

    Scaffold { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            content = {
                item {
                    MenuItem(
                        text = "User management",
                        icon = Icons.Filled.Person,
                    ) {
                        navigate(Screens.Users.route)
                    }
                }
                item {
                    MenuItem(
                        text = "Group Management",
                        icon = Icons.Filled.AccountCircle
                    ) {

                    }
                }
                item {
                    MenuItem(
                        text = "Application Scope",
                        icon = Icons.Filled.AccountCircle
                    ) {

                    }
                }
                item {
                    MenuItem(
                        text = "User Scope",
                        icon = Icons.Default.AccountCircle,
                    ) {

                    }
                }
            })
    }
}

@Composable
fun MenuItem(
    text: String,
    icon: ImageVector,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.CenterStart,
    ) {
        Icon(
            imageVector = icon, contentDescription = null,
            modifier = Modifier.offset(x = 16.dp)
        )
        Text(text, modifier = Modifier.offset(x = 72.dp))
    }
}