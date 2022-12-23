package com.asknilesh.dreamdate.screens.create_account

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.asknilesh.dreamdate.common_components.CommonButton
import com.asknilesh.dreamdate.navigation.DreamDateScreens
import com.asknilesh.dreamdate.ui.theme.ButtonColor
import com.asknilesh.dreamdate.ui.theme.LightGrey

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun SelectUserNameScreen(navController: NavHostController) {

  val userNameState = remember {
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
        title = "Select Username",
        body = "Enter username to continue."
      )
      Spacer(modifier = Modifier.height(20.dp))

      TextField(
        modifier = Modifier
          .fillMaxWidth()
          .border(0.5.dp, LightGrey, CircleShape),
        shape = CircleShape,
        value = userNameState.value,
        onValueChange = {
          userNameState.value = it
        },
        enabled = true,
        placeholder = {
          Text(
            text = "Username",
            fontSize = 18.sp,
            color = LightGrey,
            modifier = Modifier.fillMaxWidth()
          )
        },
        colors = TextFieldDefaults.textFieldColors(
          textColor = ButtonColor,
          disabledTextColor = Color.Transparent,
          containerColor = Color.Transparent,
          focusedIndicatorColor = Color.Transparent,
          unfocusedIndicatorColor = Color.Transparent,
          disabledIndicatorColor = Color.Transparent,
          disabledLeadingIconColor = LightGrey,
          disabledTrailingIconColor = LightGrey,
          disabledLabelColor = LightGrey,
          cursorColor = ButtonColor,
          focusedLabelColor = ButtonColor
        ),
        keyboardOptions = KeyboardOptions(
          keyboardType = KeyboardType.Text,
          imeAction = ImeAction.Done
        ),
        textStyle = MaterialTheme.typography.bodyLarge,
        maxLines = 1,
      )


      Spacer(
        modifier = Modifier
          .background(Color.Blue)
          .weight(1f),
      )
      CommonButton(
        buttonText = "Finish",
        enabled = userNameState.value.isNotEmpty()
      ) {
        navController.navigate(DreamDateScreens.HOME_SCREEN.name) {
          popUpTo(DreamDateScreens.SELECT_USER_NAME_SCREEN.name) {
            inclusive = true
          }
        }

      }

    }
  }
}