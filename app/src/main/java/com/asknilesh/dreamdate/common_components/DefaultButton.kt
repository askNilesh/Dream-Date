package com.asknilesh.dreamdate.common_components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.asknilesh.dreamdate.ui.theme.ButtonColor

@Composable
@Preview
fun CommonButton(
  modifier: Modifier = Modifier.fillMaxWidth(),
  buttonText: String = "Continue",
  buttonContainerColor: Color = ButtonColor,
  contentColor: Color = Color.White,
  onClick: () -> Unit = { }
) {
  ElevatedButton(
    onClick = { onClick() },
    modifier = modifier,
    colors = ButtonDefaults.buttonColors(
      containerColor = buttonContainerColor,
      contentColor = contentColor
    )
  ) {
    Text(text = buttonText)
  }
}