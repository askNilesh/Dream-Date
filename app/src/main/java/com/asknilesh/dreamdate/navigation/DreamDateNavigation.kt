package com.asknilesh.dreamdate.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.asknilesh.dreamdate.screens.intro.IntroScreen
import com.asknilesh.dreamdate.screens.login.LoginScreen

@Composable
fun DreamDateNavigation() {
  val navController = rememberNavController()
  NavHost(navController = navController, startDestination = DreamDateScreens.INTRO_SCREEN.name) {

    composable(DreamDateScreens.INTRO_SCREEN.name) {
      IntroScreen(navController = navController)
    }
    composable(DreamDateScreens.LOGIN_SCREEN.name) {
      LoginScreen()
    }

  }
}