package com.asknilesh.dreamdate.screens.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter.State.Error
import coil.compose.AsyncImagePainter.State.Loading
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.asknilesh.dreamdate.model.ChatModel
import com.asknilesh.dreamdate.ui.theme.ButtonColor
import com.asknilesh.dreamdate.ui.theme.LightGrey

@Composable
@Preview
fun ChatCardItem(
  model: ChatModel = ChatModel(
    unReadMessage = "5",
    userName = "Olivia Smith",
    userImage = "https://images.unsplash.com/photo-1609241728358-53d49c22c01a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MjV8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
  ),
  onCardClick: () -> Unit = {}
) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(start = 10.dp, top = 10.dp, bottom = 10.dp)
      .clickable { onCardClick.invoke() },
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
  ) {

    SubcomposeAsyncImage(
      model = model.userImage,
      contentDescription = null,
      modifier = Modifier
        .width(60.dp)
        .height(60.dp)
        .clip(CircleShape),
      contentScale = ContentScale.Crop,
    ) {
      val state = painter.state
      if (state is Loading || state is Error) {
        CircularProgressIndicator(
          color = ButtonColor,
          modifier = Modifier.height(60.dp)
        )
      } else {
        SubcomposeAsyncImageContent()
      }
    }
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp)
    ) {
      Row(
        modifier = Modifier
          .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
        ) {
          Text(
            text = model.userName, color = Color.White,
            fontSize = 14.sp, fontWeight = FontWeight.Bold
          )
          Spacer(modifier = Modifier.height(5.dp))
          Text(
            text = model.lastMessage,
            color = if (model.unReadMessage.isNotEmpty()) Color.White
            else Color.LightGray,
            fontWeight = if (model.unReadMessage.isNotEmpty()) FontWeight.Bold
            else FontWeight.Normal,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontSize = 12.sp
          )
        }
        if (model.unReadMessage.isNotEmpty()) {
          Box(
            modifier = Modifier
              .sizeIn(minWidth = 25.dp, minHeight = 25.dp)
              .background(color = ButtonColor, shape = RoundedCornerShape(20.dp)),
            contentAlignment = Alignment.Center
          ) {
            Text(
              text = model.unReadMessage,
              color = Color.White,
              fontSize = 12.sp,
              textAlign = TextAlign.Center,
              modifier = Modifier.padding(5.dp)
            )
          }
        }
      }
      Spacer(modifier = Modifier.height(10.dp))
      Divider(thickness = 0.5.dp, color = LightGrey)
    }
  }
}