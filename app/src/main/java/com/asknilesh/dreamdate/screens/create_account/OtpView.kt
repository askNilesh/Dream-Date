package com.asknilesh.dreamdate.screens.create_account

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asknilesh.dreamdate.ui.theme.ButtonColor
import com.asknilesh.dreamdate.ui.theme.LightGrey

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun OtpView(
  modifier: Modifier = Modifier,
  textColor: Color = Color.White,
  textState: MutableState<String>
) {
  val pattern = remember { Regex("^[^\\t]*\$") }
  val maxChar = 1
  val focusManager = LocalFocusManager.current

  val hasFocus = remember {
    mutableStateOf(false)
  }
  LaunchedEffect(
    key1 = textState.value,
  ) {
    if (textState.value.isNotEmpty()) {
      focusManager.moveFocus(
        focusDirection = FocusDirection.Next,
      )
    }
  }

  Column(
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    TextField(
      value = textState.value,
      onValueChange = {
        if (it.length <= maxChar &&
          ((it.isEmpty() || it.matches(pattern)))
        )  textState.value = it
      },
      modifier = modifier
        .width(80.dp)
        .onFocusChanged {
          hasFocus.value = it.hasFocus
        }
        .onKeyEvent {
          if (textState.value.isEmpty() && it.key == Key.Backspace) {
            focusManager.moveFocus(FocusDirection.Previous)
          }
          false
        },
      textStyle = LocalTextStyle.current.copy(
        fontSize = 20.sp,
        textAlign = TextAlign.Center,
        color = textColor,
        fontWeight = FontWeight.Bold
      ),
      keyboardOptions = KeyboardOptions(
        imeAction = ImeAction.Next,
        keyboardType = KeyboardType.Number
      ),
      colors = TextFieldDefaults.textFieldColors(
        containerColor = Transparent,
        unfocusedIndicatorColor = Transparent,
        focusedIndicatorColor = Transparent
      ),

      )
    Divider(
      Modifier
        .width(28.dp)
        .padding(bottom = 2.dp)
        .offset(y = -10.dp),
      color = if (hasFocus.value || textState.value.isNotEmpty()) ButtonColor else LightGrey,
      thickness = if (hasFocus.value || textState.value.isNotEmpty()) 2.dp else 1.dp,
    )
  }
}