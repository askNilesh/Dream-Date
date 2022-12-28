package com.asknilesh.dreamdate.screens.live

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.Icons.Outlined
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImagePainter.State.Error
import coil.compose.AsyncImagePainter.State.Loading
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.asknilesh.dreamdate.ui.theme.ButtonColor
import com.asknilesh.dreamdate.ui.theme.LightGrey

@Composable
fun LiveScreenActionBar(navController: NavController) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .wrapContentHeight(),
    horizontalArrangement = Arrangement.Center,
    verticalAlignment = Alignment.CenterVertically
  ) {
    IconButton(
      onClick = { navController.popBackStack() },
      modifier = Modifier
        .width(30.dp)
        .height(30.dp)
        .clip(CircleShape)
        .background(LightGrey.copy(alpha = .2f))
    ) {
      Icon(
        imageVector = Icons.Default.ArrowBack, contentDescription = "Back",
        modifier = Modifier
          .width(30.dp)
          .height(30.dp)
          .clip(CircleShape),
        tint = Color.White
      )
    }

    Spacer(modifier = Modifier.width(10.dp))

    BuildUserDetailsSection(
      modifier = Modifier
        .fillMaxWidth()
        .weight(1f)
    )
    Text(
      text = "Follow",
      modifier = Modifier
        .clip(RoundedCornerShape(5.dp))
        .background(ButtonColor)
        .padding(horizontal = 10.dp, vertical = 7.dp),
      color = Color.White,
      fontSize = 12.sp,
    )
    Spacer(modifier = Modifier.width(10.dp))
    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier
        .clip(RoundedCornerShape(5.dp))
        .background(Color(0x6A85868B))
        .padding(horizontal = 5.dp, vertical = 2.dp)
    ) {
      androidx.compose.material3.Icon(
        imageVector = Outlined.Visibility, contentDescription = "Live",
        tint = Color.White
      )
      Text(
        text = "2.8K",
        modifier = Modifier
          .padding(horizontal = 5.dp, vertical = 5.dp),
        color = Color.White,
        fontSize = 12.sp,
      )

    }
  }
}

@Composable
fun BuildUserDetailsSection(modifier: Modifier = Modifier.fillMaxWidth()) {
  Row(
    modifier = modifier, verticalAlignment = Alignment.CenterVertically
  ) {
    Spacer(modifier = Modifier.width(10.dp))
    SubcomposeAsyncImage(
      model = imageUrl,
      contentDescription = null,
      modifier = Modifier
        .width(30.dp)
        .height(30.dp)
        .clip(CircleShape)
        .border(
          border = BorderStroke(width = 1.dp, color = ButtonColor),
          shape = CircleShape
        ),
      contentScale = ContentScale.Inside,
    ) {
      val state = painter.state
      if (state is Loading || state is Error) {
        CircularProgressIndicator(
          color = ButtonColor,
          modifier = Modifier.height(30.dp)
        )
      } else {
        SubcomposeAsyncImageContent()
      }
    }
    Spacer(modifier = Modifier.width(10.dp))
    Column(
      modifier = Modifier.weight(1f)
    ) {
      Text(
        text = "lil_cutie", color = Color.White,
        fontSize = 14.sp,
      )
      Text(
        text = "22.5K", color = LightGrey,
        fontSize = 12.sp,
      )
    }
  }
}