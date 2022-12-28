package com.asknilesh.dreamdate.screens.live

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons.Outlined
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Redeem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.asknilesh.dreamdate.ui.theme.CallButtonColor
import com.asknilesh.dreamdate.ui.theme.LightGrey

@Composable
fun LiveBottomSection(navController: NavController) {
  Row(
    modifier = Modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween
  ) {
    BuildCommentTextField(
      modifier = Modifier
        .fillMaxWidth()
        .weight(1f)
    )
    Spacer(modifier = Modifier.width(5.dp))
    FloatingActionButton(
      onClick = { },
      shape = CircleShape,
      containerColor = Color(0xFF4B53FF),
    ) {
      Icon(
        imageVector = Outlined.Redeem, contentDescription = "Redeem",
        tint = Color.White
      )
    }

    Spacer(modifier = Modifier.width(5.dp))
    FloatingActionButton(
      onClick = { },
      shape = CircleShape,
      containerColor = CallButtonColor,
    ) {
      Icon(
        imageVector = Outlined.Call, contentDescription = "Call",
        tint = Color.White
      )
    }
    Spacer(modifier = Modifier.width(5.dp))

    FloatingActionButton(
      onClick = { },
      shape = CircleShape,
      containerColor = LightGrey.copy(alpha = .5f),
    ) {
      Icon(
        imageVector = Outlined.Menu, contentDescription = "Menu",
        tint = Color.White
      )
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun BuildCommentTextField(modifier: Modifier = Modifier.fillMaxWidth()) {
  var commentState by remember {
    mutableStateOf("")
  }
  TextField(
    value = commentState,
    placeholder = { Text(text = "Type...") },
    onValueChange = {
      commentState = it
    },
    maxLines = 1,
    keyboardOptions = KeyboardOptions(
      keyboardType = KeyboardType.Text,
      imeAction = ImeAction.Done
    ),
    shape = RoundedCornerShape(30.dp),
    colors = TextFieldDefaults.textFieldColors(
      focusedIndicatorColor = Color.Transparent,
      unfocusedIndicatorColor = Color.Transparent,
      cursorColor = Color.White,
      containerColor = LightGrey.copy(alpha = .2f),
      textColor = Color.White,
      placeholderColor = Color.White
    ),
    modifier = modifier,
    readOnly = true

  )
}