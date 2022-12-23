package com.asknilesh.dreamdate.screens.create_account

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.asknilesh.dreamdate.R
import com.asknilesh.dreamdate.common_components.CommonButton
import com.asknilesh.dreamdate.navigation.DreamDateScreens.SELECT_USER_NAME_SCREEN

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun GenderSelectionScreen(navController: NavHostController) {
  val male = remember {
    mutableStateOf(true)
  }
  val female = remember {
    mutableStateOf(false)
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
        title = "Gender selection",
        body = "Gender can’t be change once submited!"
      )
      Spacer(modifier = Modifier.height(20.dp))

      GenderSelectionCard(
        genderText = "Male",
        genderState = male,
        painter = painterResource(id = R.drawable.ic_male)
      ) {
        male.value = !male.value
        if (male.value) {
          female.value = false
        }
      }

      GenderSelectionCard(
        genderText = "Female",
        genderState = female,
        painter = painterResource(id = R.drawable.ic_female)
      ) {
        female.value = !female.value
        if (female.value) {
          male.value = false
        }
      }

      Spacer(
        modifier = Modifier
          .background(Color.Blue)
          .weight(1f),
      )
      CommonButton(
        buttonText = "Next",
      ) {
        navController.navigate(SELECT_USER_NAME_SCREEN.name)
      }

    }
  }
}