package com.example.interviewcoach.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

import com.example.interviewcoach.ui.components.BottomNavigationBar
import com.example.interviewcoach.ui.screens.ai.PracticeScreen
import com.example.interviewcoach.ui.screens.home.HomeScreen
import com.example.interviewcoach.ui.screens.progress.ProgressScreen
import com.example.interviewcoach.ui.screens.saved.SavedScreen
import com.example.interviewcoach.ui.screens.topics.TopicsScreen
import com.example.interviewcoach.viewmodel.CoachViewModel

object Routes {
    const val HOME = "home"
    const val TOPICS = "topics"
    const val PROGRESS = "progress"
    const val SAVED = "saved"

    const val AI_TEST = "ai_test"
}

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
    viewModel: CoachViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        modifier = modifier,
        bottomBar = {
            BottomNavigationBar(
                currentRoute = currentRoute,
                onItemClick = { route ->
                    navController.navigate(route) {
                        popUpTo(Routes.HOME) {
                            saveState = true
                        }

                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = Routes.AI_TEST,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Routes.HOME) {
                HomeScreen(
                    viewModel = viewModel
                )
            }

            composable(Routes.TOPICS) {
                TopicsScreen()
            }

            composable(Routes.PROGRESS) {
                ProgressScreen(
                    viewModel = viewModel
                )
            }

            composable(Routes.SAVED) {
                SavedScreen(
                    viewModel = viewModel
                )
            }

            composable(Routes.AI_TEST) {
                PracticeScreen(viewModel = viewModel)
            }
        }
    }
}