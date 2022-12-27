package com.asknilesh.dreamdate.screens.dashboard

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

typealias ComposableFun = @Composable () -> Unit

sealed class DashBoardTabItem(
  var title: String,
  var screen: ComposableFun,
)

class ForYouTab(navController: NavController) :
  DashBoardTabItem("For You", { DashBoardForYouScreen(navController) })

class FollowingTab(navController: NavController) :
  DashBoardTabItem("Following", { DashBoardForYouScreen(navController) })
