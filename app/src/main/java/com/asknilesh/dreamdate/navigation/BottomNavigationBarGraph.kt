package com.asknilesh.dreamdate.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.asknilesh.dreamdate.screens.chat.MessagesScreen
import com.asknilesh.dreamdate.screens.dashboard.DashBoardScreen
import com.asknilesh.dreamdate.screens.explore.ExploreScreen
import com.asknilesh.dreamdate.screens.live.UserLiveScreen
import com.asknilesh.dreamdate.screens.profile.ProfileScreen
import com.asknilesh.dreamdate.screens.short.ShortsScreen

@Composable
fun BottomNavigationBarGraph(navController: NavHostController, mainNavController: NavController) {
  NavHost(
    navController = navController,
    startDestination = DreamDateScreens.DASHBOARD_SCREEN.name,
  ) {
    composable(DreamDateScreens.DASHBOARD_SCREEN.name) {
      DashBoardScreen(mainNavController)
    }
    composable(DreamDateScreens.EXPLORE_SCREEN.name) {
      ExploreScreen(navController = mainNavController)
    }
    composable(DreamDateScreens.SHORTS_SCREEN.name) {
      ShortsScreen(navController = mainNavController)
    }
    composable(DreamDateScreens.MESSAGES_SCREEN.name) {
      MessagesScreen(navController = mainNavController)
    }
    composable(DreamDateScreens.PROFILE_SCREEN.name) {
      ProfileScreen(navController = mainNavController)
    }
    composable(DreamDateScreens.PROFILE_SCREEN.name) {
      ProfileScreen(navController = mainNavController)
    }

    composable(DreamDateScreens.LIVE_SCREEN.name) {
      UserLiveScreen(navController = mainNavController)
    }

  }
}