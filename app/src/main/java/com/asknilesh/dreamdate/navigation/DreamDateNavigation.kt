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

  }
}