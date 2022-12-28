package com.asknilesh.dreamdate.screens.live

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter.State.Error
import coil.compose.AsyncImagePainter.State.Loading
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.asknilesh.dreamdate.ui.theme.ButtonColor

@Composable fun LiveCommentSection() {

  LazyColumn {
    items(getCommentList()) { model ->
      CommentSectionCard(model = model)
    }
  }
}

@Composable fun CommentSectionCard(
  modifier: Modifier = Modifier.fillMaxWidth(),
  model: CommentModel
) {
  Row(
    modifier = modifier.padding(vertical = 10.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    Spacer(modifier = Modifier.width(10.dp))
    SubcomposeAsyncImage(
      model = model.userImage,
      contentDescription = null,
      modifier = Modifier
        .width(40.dp)
        .height(40.dp)
        .clip(CircleShape)
        .border(
          border = BorderStroke(width = 1.dp, color = ButtonColor), shape = CircleShape
        ),
      contentScale = ContentScale.Inside,
    ) {
      val state = painter.state
      if (state is Loading || state is Error) {
        CircularProgressIndicator(
          color = ButtonColor, modifier = Modifier.height(40.dp)
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
        text = model.userName,
        color = Color.White,
        fontSize = 16.sp,
      )
      Text(
        text = model.message,
        color = Color.White,
        fontSize = 14.sp,
      )
    }
  }
}

data class CommentModel(
  val userName: String, val message: String, val userImage: String
)

fun getCommentList() = listOf(
  CommentModel(
    userName = "lil_cutie",
    message = "Has join the room.",
    userImage = "https://images.unsplash.com/photo-1459356979461-dae1b8dcb702?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8Ym95fGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60"
  ),
  CommentModel(
    userName = "superb_guy",
    message = "Has join the room.",
    userImage = "https://images.unsplash.com/photo-1506968695017-764f86a9f9ec?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTR8fGJveXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60"
  ),

  CommentModel(
    userName = "beauty.babe",
    message = "Has join the room.",
    userImage = "https://images.unsplash.com/photo-1577975882846-431adc8c2009?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzB8fGJveXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60"
  ),

  CommentModel(
    userName = "ghost_rider",
    message = "Has join the room.",
    userImage = "https://images.unsplash.com/photo-1602030028438-4cf153cbae9e?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NDJ8fGJveXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60"
  ),

  CommentModel(
    userName = "instafreack",
    message = "Has join the room.",
    userImage = "https://images.unsplash.com/photo-1463674349210-38e4fa154dda?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NTB8fGJveXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60"
  ),

  CommentModel(
    userName = "romantic_boy",
    message = "Has join the room.",
    userImage = "https://images.unsplash.com/photo-1603923407940-e9b8decf8d4f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NjR8fGJveXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60"
  ),
)