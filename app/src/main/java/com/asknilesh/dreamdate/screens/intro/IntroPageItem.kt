package com.asknilesh.dreamdate.screens.intro

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asknilesh.dreamdate.R

@Composable
@Preview
fun IntroPageItem() {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .fillMaxHeight()
      .padding(horizontal = 20.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {
    Spacer(modifier = Modifier.height(20.dp))

    Text(
      text = "What is Lorem Ipsum?",
      style = MaterialTheme.typography.headlineLarge,
      color = Color.White,
      textAlign = TextAlign.Center,
      fontWeight = FontWeight.Bold
    )

    Spacer(modifier = Modifier.height(20.dp))

    Text(
      text = stringResource(id = R.string.dummy_text),
      style = MaterialTheme.typography.bodyLarge,
      textAlign = TextAlign.Justify,
      color = Color.DarkGray
    )



  }
}