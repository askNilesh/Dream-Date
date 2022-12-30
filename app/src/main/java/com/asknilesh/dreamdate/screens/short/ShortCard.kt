package com.asknilesh.dreamdate.screens.short

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter.State.Error
import coil.compose.AsyncImagePainter.State.Loading
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.asknilesh.dreamdate.model.ShortsModel
import com.asknilesh.dreamdate.ui.theme.ButtonColor

@Composable
@Preview
fun ShortCard(
  model: ShortsModel = ShortsModel(
    userName = "lil_cutie",
    following = true,
    userImage = "https://images.unsplash.com/photo-1609241728358-53d49c22c01a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MjV8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
    caption = "I'm smiling reel big today",
    likes = "22K",
    comments = "43K",
  )
) {
  val screenHeight = LocalConfiguration.current.screenHeightDp
  Box(
    modifier = Modifier
      .fillMaxWidth()
      .fillMaxHeight(),
    contentAlignment = Alignment.BottomStart
  ) {
    SubcomposeAsyncImage(
      model = model.userImage,
      contentDescription = null,
      modifier = Modifier
        .height(screenHeight.dp - 50.dp)
        .fillMaxWidth(1f),
      contentScale = ContentScale.Crop,
    ) {
      SubcomposeAsyncImageContent()
    }
    Column {
      BuildBottomSection(model)
      Text(
        text = model.caption, color = Color.White,
        fontSize = 16.sp, fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(10.dp)
      )
      Spacer(modifier = Modifier.height(20.dp))
    }
  }
}

@Composable
fun BuildBottomSection(
  model: ShortsModel
) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(10.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.Start
  ) {
    SubcomposeAsyncImage(
      model = model.userImage,
      contentDescription = null,
      modifier = Modifier
        .width(40.dp)
        .height(40.dp)
        .clip(CircleShape),
      contentScale = ContentScale.Crop,
    ) {
      val state = painter.state
      if (state is Loading || state is Error) {
        CircularProgressIndicator(
          color = ButtonColor,
          modifier = Modifier.height(40.dp)
        )
      } else {
        SubcomposeAsyncImageContent()
      }
    }
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp)
        .weight(1f)
    ) {
      Text(
        text = model.userName, color = Color.White,
        fontSize = 14.sp, fontWeight = FontWeight.Bold
      )
      Text(
        text = "12k Followers", color = Color.White,
        fontSize = 12.sp
      )
    }
    if (!model.following) {
      Button(
        onClick = {
        },
        modifier = Modifier.width(20.dp),
        colors = ButtonDefaults.buttonColors(
          containerColor = if (model.following) ButtonColor else Color.Transparent
        ),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(
          width = 0.5.dp,
          color = ButtonColor
        ),
        contentPadding = PaddingValues(0.dp)
      ) {
        Text(text = "Follow ")
      }
    }
  }
}