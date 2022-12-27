package com.asknilesh.dreamdate.screens.homescreen

import com.asknilesh.dreamdate.R
import com.asknilesh.dreamdate.navigation.DreamDateScreens

sealed class BottomNavItem(var title: String, var icon: Int, var screenName: String) {

  object Home : BottomNavItem("", R.drawable.ic_home, DreamDateScreens.DASHBOARD_SCREEN.name)
  object Explore : BottomNavItem("", R.drawable.ic_explore, DreamDateScreens.EXPLORE_SCREEN.name)
  object Shorts : BottomNavItem("", R.drawable.ic_short, DreamDateScreens.SHORTS_SCREEN.name)
  object Messages : BottomNavItem("", R.drawable.ic_chat, DreamDateScreens.MESSAGES_SCREEN.name)
  object Profile : BottomNavItem("", R.drawable.ic_profile, DreamDateScreens.PROFILE_SCREEN.name)
}