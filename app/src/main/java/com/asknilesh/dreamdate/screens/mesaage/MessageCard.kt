package com.asknilesh.dreamdate.screens.mesaage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asknilesh.dreamdate.model.MessageModel

@Composable
fun MessageCard(
  model: MessageModel = MessageModel(
    message = "lorepom ipsum",
    timeStamp = "9:15 am",
    isOtherUserMessage = false,
  )
) {
  Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = if (model.isOtherUserMessage) Arrangement.Start
    else Arrangement.End
  ) {
    if (model.isOtherUserMessage) {
      OtherUserMessageCard(model)
    } else {
      UserMessageCard(model)
    }
  }
}

@Composable
@Preview
fun OtherUserMessageCard(
  model: MessageModel = MessageModel(
    message = "lorepom ipsum",
    timeStamp = "9:15 am",
    isOtherUserMessage = false,
  )
) {
  Row(
    modifier = Modifier
      .wrapContentWidth()
      .padding(10.dp)
      .background(
        color = Color(0xff4B53FF),
        shape = RoundedCornerShape(
          topStart = 0.dp,
          bottomStart = 10.dp,
          topEnd = 10.dp,
          bottomEnd = 10.dp
        )
      ),
    horizontalArrangement = Arrangement.Start,
    verticalAlignment = Alignment.CenterVertically
  ) {
    Column {
      Text(
        text = model.message,
        color = Color.White,
        fontSize = 16.sp,
        modifier = Modifier.padding(vertical = 5.dp, horizontal = 5.dp)
      )
      Text(
        text = model.timeStamp,
        color = Color.LightGray,
        fontSize = 16.sp,
        modifier = Modifier.padding(horizontal = 5.dp)

      )
    }

  }
}

@Composable
@Preview
fun UserMessageCard(
  model: MessageModel = MessageModel(
    message = "lorepom ipsum",
    timeStamp = "",
    isOtherUserMessage = false,
  )
) {
  Row(
    modifier = Modifier
      .wrapContentWidth()
      .padding(10.dp)
      .background(
        color = Color(0xff4B53FF),
        shape = RoundedCornerShape(
          topStart = 10.dp,
          bottomStart = 10.dp,
          topEnd = 0.dp,
          bottomEnd = 10.dp
        )
      ),
    horizontalArrangement = Arrangement.End,
    verticalAlignment = Alignment.CenterVertically
  ) {
    Column {
      Text(
        text = model.message,
        color = Color.White,
        fontSize = 16.sp,
        modifier = Modifier.padding(vertical = 5.dp, horizontal = 5.dp)
      )
      Text(
        text = model.timeStamp,
        color = Color.LightGray,
        fontSize = 16.sp,
        modifier = Modifier.padding(horizontal = 5.dp)

      )
    }

  }
}