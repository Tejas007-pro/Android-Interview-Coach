package com.example.interviewcoach.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import com.example.interviewcoach.navigation.Routes

data class BottomNavItem(
    val route: String,
    val label: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
)

@Composable
fun BottomNavigationBar(
    currentRoute: String?,
    onItemClick: (String) -> Unit
) {
    val items = listOf(
        BottomNavItem(
            route = Routes.HOME,
            label = "Home",
            icon = Icons.Default.Home
        ),
        BottomNavItem(
            route = Routes.TOPICS,
            label = "Topics",
            icon = Icons.Default.MenuBook
        ),
        BottomNavItem(
            route = Routes.PROGRESS,
            label = "Progress",
            icon = Icons.Default.TrendingUp
        ),
        BottomNavItem(
            route = Routes.SAVED,
            label = "Saved",
            icon = Icons.Default.Bookmark
        )
    )

    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    onItemClick(item.route)
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label
                    )
                },
                label = {
                    Text(item.label)
                }
            )
        }
    }
}