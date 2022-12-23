package com.asknilesh.dreamdate.screens.create_account

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.asknilesh.dreamdate.common_components.CommonButton

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
fun VerifyOtpScreen(navController: NavHostController) {
  val (item1, item2, item3, item4) = FocusRequester.createRefs()
  val otpOne = remember {
    mutableStateOf("")
  }
  val otpTwo = remember {
    mutableStateOf("")
  }
  val otpThree = remember {
    mutableStateOf("")
  }
  val otpFour = remember {
    mutableStateOf("")
  }
  Scaffold(
    modifier = Modifier
      .fillMaxWidth()
      .fillMaxHeight(),
    containerColor = Color.Black,
  ) { paddings ->
    Column(
      modifier = Modifier
        .fillMaxSize()
        .fillMaxHeight()
        .padding(20.dp)
        .verticalScroll(rememberScrollState())
    ) {
      Spacer(modifier = Modifier.height(10.dp))
      Icon(imageVector = Icons.Default.ArrowBack,
        contentDescription = "Back",
        tint = Color.White,
        modifier = Modifier.clickable {

        })
      Spacer(modifier = Modifier.height(20.dp))
      CommonTextForSignUp(
        title = "OTP Verification",
        body = "Need to verify OTP sent on your mobile number. We have sent a verification code to +92 123 123 1234"
      )
      Spacer(modifier = Modifier.height(20.dp))

      Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
      ) {
        OtpView(
          modifier = Modifier
            .focusRequester(item1)
            .focusProperties {
              next = item2
              previous = item1
            },
          textState = otpOne
        )
        OtpView(
          modifier = Modifier
            .focusRequester(item2)
            .focusProperties {
              next = item3
              previous = item1
            },
          textState = otpTwo
        )
        OtpView(
          modifier = Modifier
            .focusRequester(item3)
            .focusProperties {
              next = item4
              previous = item2
            },
          textState = otpThree
        )
        OtpView(
          modifier = Modifier
            .focusRequester(item4)
            .focusProperties {
              previous = item3
              next = item4
            },
          textState = otpFour
        )

      }

      Spacer(
        modifier = Modifier
          .background(Color.Blue)
          .weight(1f),
      )
      CommonButton(
        buttonText = "Verify", enabled = (
          otpOne.value.isNotEmpty() &&
            otpTwo.value.isNotEmpty() &&
            otpThree.value.isNotEmpty() &&
            otpFour.value.isNotEmpty()
          )
      ) {
        // navController.navigate(VERIFY_OTP_SCREEN.name)
      }

    }
  }
}