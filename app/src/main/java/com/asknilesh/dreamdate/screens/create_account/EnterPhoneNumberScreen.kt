package com.asknilesh.dreamdate.screens.create_account

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.imePadding
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asknilesh.dreamdate.R
import com.asknilesh.dreamdate.common_components.CommonButton
import com.asknilesh.dreamdate.common_components.PrefixTransformation
import com.asknilesh.dreamdate.ui.theme.LightGrey

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable @Preview(showSystemUi = true)
fun EnterPhoneNumberScreen() {
  val countryState = remember {
    mutableStateOf("")
  }
  val phoneNumberState = remember {
    mutableStateOf("")
  }
  Scaffold(
    modifier = Modifier
      .fillMaxWidth()
      .fillMaxHeight()
    ,
    containerColor = Color.Black,
  ) { paddings ->

    Column(
      modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding( 20.dp )
        .verticalScroll(rememberScrollState())
    ) {
      Spacer(modifier = Modifier.height(10.dp))
      Icon(imageVector = Icons.Default.ArrowBack,
        contentDescription = "Back",
        tint = Color.White,
        modifier = Modifier.clickable {

        })
      Spacer(modifier = Modifier.height(20.dp))

      Text(
        text = "Let’s get started!",
        style = MaterialTheme.typography.headlineSmall,
        color = Color.White,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold
      )

      Spacer(modifier = Modifier.height(5.dp))

      Text(
        text = "Welcome to Dream Date.",
        style = MaterialTheme.typography.bodyLarge,
        textAlign = TextAlign.Justify,
        color = Color.DarkGray
      )
      Spacer(modifier = Modifier.height(40.dp))

      TextField(
        modifier = Modifier
          .fillMaxWidth()
          .border(0.5.dp, LightGrey, CircleShape),

        shape = CircleShape,
        value = countryState.value,
        onValueChange = {
          countryState.value = it
        },
        enabled = false,
        leadingIcon = {
          Icon(
            painter = painterResource(id = R.drawable.ic_world),
            contentDescription = "Select country"
          )
        },
        trailingIcon = {
          Icon(
            painter = painterResource(id = R.drawable.ic_down),
            contentDescription = "Select country"
          )
        },
        placeholder = {
          Text(
            text = "Select country",
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            color = LightGrey,
            modifier = Modifier.fillMaxWidth()
          )
        },
        colors = TextFieldDefaults.textFieldColors(
          textColor = Color.White,
          disabledTextColor = Color.Transparent,
          containerColor = Color.Transparent,
          focusedIndicatorColor = Color.Transparent,
          unfocusedIndicatorColor = Color.Transparent,
          disabledIndicatorColor = Color.Transparent,
          disabledLeadingIconColor = LightGrey,
          disabledTrailingIconColor = LightGrey,
          disabledLabelColor = LightGrey
        ),
        textStyle = MaterialTheme.typography.bodyLarge
      )
      Spacer(modifier = Modifier.height(20.dp))
      TextField(
        modifier = Modifier
          .fillMaxWidth()
          .border(0.5.dp, LightGrey, CircleShape),
        shape = CircleShape,
        value = phoneNumberState.value,
        onValueChange = {
          phoneNumberState.value = it
        },
        enabled = true,
        leadingIcon = {
          Icon(
            painter = painterResource(id = R.drawable.ic_call),
            contentDescription = "Phone Number"
          )
        },
        placeholder = {
          Text(
            text = "XXX  XXX  XX  XX",
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            color = LightGrey,
            modifier = Modifier.fillMaxWidth()
          )
        },
        colors = TextFieldDefaults.textFieldColors(
          textColor = Color.White,
          disabledTextColor = Color.Transparent,
          containerColor = Color.Transparent,
          focusedIndicatorColor = Color.Transparent,
          unfocusedIndicatorColor = Color.Transparent,
          disabledIndicatorColor = Color.Transparent,
          disabledLeadingIconColor = LightGrey,
          disabledTrailingIconColor = LightGrey,
          disabledLabelColor = LightGrey
        ),
        visualTransformation = PrefixTransformation("+91 "),
        keyboardOptions = KeyboardOptions(
          keyboardType = KeyboardType.Phone,
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
      CommonButton(buttonText = "Next")


    }

  }
}