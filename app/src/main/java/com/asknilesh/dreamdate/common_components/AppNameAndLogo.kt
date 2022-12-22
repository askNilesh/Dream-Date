package com.asknilesh.dreamdate.common_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asknilesh.dreamdate.R
import com.asknilesh.dreamdate.R.string

@Composable
@Preview
fun BuildAppNameAndLogo() {
  Column(
    modifier = Modifier.fillMaxWidth(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {
    Card(
      modifier = Modifier
        .width(100.dp)
        .height(100.dp)
        .padding(10.dp)
        .clip(CircleShape)
        .background(color = Color.White),
    ) {
      Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
      ) {
        Image(
          painter = painterResource(id = R.drawable.app_icon),
          contentDescription = "App logo",
          modifier = Modifier
            .width(60.dp)
            .height(60.dp),
          contentScale = ContentScale.Crop
        )

      }
    }
    Text(
      text = stringResource(id = string.app_name),
      color = Color.White, fontSize = 20.sp,
      fontWeight = FontWeight.Bold,
      fontStyle = FontStyle.Italic
    )
  }
}