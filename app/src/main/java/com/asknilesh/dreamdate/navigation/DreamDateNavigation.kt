package com.asknilesh.dreamdate.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.asknilesh.dreamdate.screens.create_account.EnterPhoneNumberScreen
import com.asknilesh.dreamdate.screens.create_account.GenderSelectionScreen
import com.asknilesh.dreamdate.screens.create_account.SelectUserNameScreen
import com.asknilesh.dreamdate.screens.create_account.VerifyOtpScreen
import com.asknilesh.dreamdate.screens.homescreen.HomeScreen
import com.asknilesh.dreamdate.screens.intro.IntroScreen
import com.asknilesh.dreamdate.screens.live.UserLiveScreen
import com.asknilesh.dreamdate.screens.login.LoginScreen
import com.asknilesh.dreamdate.screens.notification.NotificationScreen
import com.asknilesh.dreamdate.screens.post_screen.NewPostScreen
import com.asknilesh.dreamdate.screens.user_profile.UserProfileScreen

const val ROOT_ROUTE = "ROOT_ROUTE"

@Composable
fun DreamDateNavigation() {
  val navController = rememberNavController()
  NavHost(
    navController = navController,
    startDestination = DreamDateScreens.HOME_SCREEN.name,
    route = ROOT_ROUTE
  ) {
    composable(DreamDateScreens.INTRO_SCREEN.name) {
      IntroScreen(navController = navController)
    }
    composable(DreamDateScreens.LOGIN_SCREEN.name) {
      LoginScreen(navController = navController)
    }
    composable(DreamDateScreens.ENTER_PHONE_NUMBER_SCREEN.name) {
      EnterPhoneNumberScreen(navController = navController)
    }
    composable(DreamDateScreens.VERIFY_OTP_SCREEN.name) {
      VerifyOtpScreen(navController = navController)
    }
    composable(DreamDateScreens.GENDER_SELECTION_SCREEN.name) {
      GenderSelectionScreen(navController = navController)
    }
    composable(DreamDateScreens.SELECT_USER_NAME_SCREEN.name) {
      SelectUserNameScreen(navController = navController)
    }
    composable(DreamDateScreens.HOME_SCREEN.name) {
      HomeScreen(navController)
    }
    composable(DreamDateScreens.LIVE_SCREEN.name) {
      UserLiveScreen(navController = navController)
    }
    composable(DreamDateScreens.NOTIFICATION_SCREEN.name) {
      NotificationScreen(navController = navController)
    }
    composable(DreamDateScreens.ADD_NEW_POST_SCREEN.name) {
      NewPostScreen(navController = navController)
    }
    composable(DreamDateScreens.USER_PROFILE_SCREEN.name) {
      UserProfileScreen()
    }

  }
}