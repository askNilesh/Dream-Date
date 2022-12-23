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
import com.asknilesh.dreamdate.ui.theme.LightGrey

@Composable
@Preview
fun CommonButton(
  modifier: Modifier = Modifier.fillMaxWidth(),
  buttonText: String = "Continue",
  buttonContainerColor: Color = ButtonColor,
  contentColor: Color = Color.White,
  enabled : Boolean = true,
  onClick: () -> Unit = { }
) {
  ElevatedButton(
    onClick = { onClick() },
    modifier = modifier,
    enabled = enabled,
    colors = ButtonDefaults.buttonColors(
      containerColor = buttonContainerColor,
      contentColor = contentColor,
      disabledContainerColor = buttonContainerColor.copy(alpha = 0.8f),
      disabledContentColor = LightGrey
    )
  ) {
    Text(text = buttonText)
  }
}