package com.asknilesh.dreamdate.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.asknilesh.dreamdate.screens.chat.MessagesScreen
import com.asknilesh.dreamdate.screens.explore.ExploreScreen
import com.asknilesh.dreamdate.screens.homescreen.DashBoardScreen
import com.asknilesh.dreamdate.screens.profile.ProfileScreen
import com.asknilesh.dreamdate.screens.short.ShortsScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
  NavHost(navController, startDestination = DreamDateScreens.DASHBOARD_SCREEN.name) {
    composable(DreamDateScreens.DASHBOARD_SCREEN.name) {
      DashBoardScreen(navController = navController)
    }
    composable(DreamDateScreens.EXPLORE_SCREEN.name) {
      ExploreScreen(navController = navController)
    }
    composable(DreamDateScreens.SHORTS_SCREEN.name) {
      ShortsScreen(navController = navController)
    }
    composable(DreamDateScreens.MESSAGES_SCREEN.name) {
      MessagesScreen(navController = navController)
    }
    composable(DreamDateScreens.PROFILE_SCREEN.name) {
      ProfileScreen(navController = navController)
    }

  }
}