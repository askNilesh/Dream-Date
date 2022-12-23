package com.asknilesh.dreamdate.screens.create_account

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun CommonTextForSignUp(
  title: String = "Let’s get started!",
  body: String = "Welcome to Dream Date."
) {
  Column() {
    Text(
      text = title,
      style = MaterialTheme.typography.headlineSmall,
      color = Color.White,
      textAlign = TextAlign.Center,
      fontWeight = FontWeight.Bold
    )

    Spacer(modifier = Modifier.height(5.dp))

    Text(
      text = body,
      style = MaterialTheme.typography.bodyLarge,
      textAlign = TextAlign.Justify,
      color = Color.DarkGray
    )
  }
}