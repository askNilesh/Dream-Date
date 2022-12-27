package com.asknilesh.dreamdate.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.asknilesh.dreamdate.common_components.BuildAppNameAndLogo
import com.asknilesh.dreamdate.navigation.DreamDateScreens

@Composable
fun LoginScreen(navController: NavHostController) {

  val uriHandler = LocalUriHandler.current

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .fillMaxHeight()
      .verticalScroll(rememberScrollState()),
    verticalArrangement = Arrangement.SpaceBetween
  ) {
    BuildAppNameAndLogo()

    BuildLoginButtons(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 30.dp)
    ) {
      navController.navigate(DreamDateScreens.ENTER_PHONE_NUMBER_SCREEN.name)
    }
    BuildTermAndPrivacy(modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 30.dp),
      onPolicyCLick = { policyUrl ->
        uriHandler.openUri(policyUrl)
      }, onTermsClick =
      { termsUrl ->
        uriHandler.openUri(termsUrl)
      })
  }
}