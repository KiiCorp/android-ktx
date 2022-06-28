package com.kii.cloud.storage.ktx.demo.core.ui.menu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(
    menuItems: List<MenuItem>,
    navigate: (route: String) -> Unit,
) {
    Scaffold { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues),
            content = {
                items(menuItems) { menuItem ->
                    MenuItem(menuItem) {
                        navigate(menuItem.route)
                    }
                }
            },
        )
    }
}

@Composable
fun MenuItem(
    menuItem: MenuItem,
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
            painter = painterResource(id = menuItem.icon), contentDescription = null,
            modifier = Modifier.offset(x = 16.dp)
        )
        Text(menuItem.text, modifier = Modifier.offset(x = 72.dp))
    }
}
