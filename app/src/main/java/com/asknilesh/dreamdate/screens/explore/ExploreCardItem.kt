package com.asknilesh.dreamdate.screens.explore

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter.State.Error
import coil.compose.AsyncImagePainter.State.Loading
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.asknilesh.dreamdate.model.ExploreModel
import com.asknilesh.dreamdate.ui.theme.ButtonColor

@Composable
fun BuildExploreCard(
  model: ExploreModel,
  onCardClick: () -> Unit = {},
) {

  Box(
    modifier = Modifier
      .padding(2.dp)
      .clickable {
        onCardClick.invoke()
      },
    contentAlignment = Companion.BottomCenter
  ) {
    AsyncImage(
      model = model.posterImage,
      contentDescription = null,
      modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight(),
      contentScale = ContentScale.Crop
    )
    Column(
      verticalArrangement = Arrangement.SpaceBetween,
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier.fillMaxHeight()

    ) {
      Spacer(modifier = Modifier.height(10.dp))
      Row(
        modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
      ) {
        Spacer(modifier = Modifier.width(10.dp))
        SubcomposeAsyncImage(
          model = model.userImage,
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
        Column {
          Text(
            text = model.userName, color = White,
            fontSize = 14.sp,
          )
          Text(
            text = model.totalFollower, color = White,
            fontSize = 12.sp,
          )
        }
      }
    }
  }
}
