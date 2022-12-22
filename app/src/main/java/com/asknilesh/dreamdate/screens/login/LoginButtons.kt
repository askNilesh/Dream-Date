package com.asknilesh.dreamdate.screens.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asknilesh.dreamdate.R.drawable
import com.asknilesh.dreamdate.ui.theme.SocialButtonColor

@Composable
@Preview
fun BuildLoginButtons(
  modifier: Modifier = Modifier.fillMaxWidth(),
  onClick: () -> Unit = {}
) {
  Column(modifier = modifier) {
    SocialSignButton(
      buttonText = "Continue with Google",
      fontColor = Color.White,
      imageVector = painterResource(id = drawable.ic_google)
    ) {
      onClick()
    }
    Spacer(modifier = Modifier.height(10.dp))
    SocialSignButton(
      buttonText = "Continue with Facebook",
      fontColor = Color.White,
      imageVector = painterResource(id = drawable.ic_facebook)
    ) {
      onClick()
    }
    Spacer(modifier = Modifier.height(10.dp))
    SocialSignButton(
      buttonText = "Continue with Apple",
      fontColor = Color.White,
      imageVector = painterResource(id = drawable.ic_apple)
    ) {
      onClick()
    }

    Spacer(modifier = Modifier.height(10.dp))
    SocialSignButton(
      buttonText = "Continue with Phone",
      fontColor = Color.White,
      imageVector = painterResource(id = drawable.ic_call)
    ) {
      onClick()
    }
  }
}

@Composable
fun SocialSignButton(
  modifier: Modifier = Modifier.fillMaxWidth(),
  imageVector: Painter,
  buttonText: String,
  backgroundColor: Color = SocialButtonColor,
  fontColor: Color,
  onClick: () -> Unit = {},
) {
  Button(
    onClick = { onClick() },
    modifier = modifier
      .fillMaxWidth()
      .shadow(0.dp),
    elevation = ButtonDefaults.buttonElevation(
      defaultElevation = 0.dp,
      pressedElevation = 0.dp,
      hoveredElevation = 0.dp,
      focusedElevation = 0.dp
    ),
    shape = RoundedCornerShape(28.dp),
    contentPadding = PaddingValues(15.dp),
    colors = ButtonDefaults.buttonColors(
      containerColor = backgroundColor,
      contentColor = fontColor
    ),
    border = BorderStroke(1.dp, color = Color.DarkGray)
  ) {
    Box(
      modifier = Modifier
        .fillMaxWidth(),
      contentAlignment = Alignment.Center
    ) {
      Row(
        modifier = Modifier
          .wrapContentWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Spacer(modifier = Modifier.width(30.dp))
        Icon(
          painter = imageVector,
          modifier = Modifier
            .weight(0.2f)
            .size(24.dp),
          contentDescription = "drawable_icons",
          tint = Color.Unspecified,
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
          text = buttonText,
          color = Color.White,
          textAlign = TextAlign.Start,
          fontSize = 18.sp,
          modifier = Modifier.weight(0.8f)
        )

      }
    }
  }
}