package com.asknilesh.dreamdate.screens.followers

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter.State.Error
import coil.compose.AsyncImagePainter.State.Loading
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.asknilesh.dreamdate.model.MyFollowerModel
import com.asknilesh.dreamdate.ui.theme.ButtonColor
import com.asknilesh.dreamdate.ui.theme.LightGrey

@Composable
@Preview
fun UserFollowerCard(
  model: MyFollowerModel = MyFollowerModel(
    userName = "girlyapa",
    following = true,
    userImage = "https://images.unsplash.com/photo-1612751747121-543c0be0f58f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTI1fHxnaXJsJTIwYWxvbmV8ZW58MHx8MHx8&auto=format&fit=crop&w=800&q=60",
  ),
  position: Int = 0,
  onClick: (Int) -> Unit = {}
) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(10.dp)
      ,
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween
  ) {
    SubcomposeAsyncImage(
      model = model.userImage,
      contentDescription = null,
      modifier = Modifier
        .width(60.dp)
        .height(60.dp)
        .clip(CircleShape)
        .border(
          border = BorderStroke(width = 1.dp, color = ButtonColor),
          shape = CircleShape
        ),
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
        .weight(1f)
    ) {
      Text(
        text = model.name, color = Color.White,
        fontSize = 18.sp, fontWeight = FontWeight.Bold
      )
      Text(
        text = "@${model.userName}", color = LightGrey,
        fontSize = 14.sp
      )
    }
    Button(
      onClick = {
        onClick.invoke(position)
      },
      modifier = Modifier.width(100.dp),
      colors = ButtonDefaults.buttonColors(
        containerColor = if (model.following) ButtonColor else Color.Transparent
      ),
      shape = RoundedCornerShape(10.dp),
      border = BorderStroke(
        width = 0.5.dp,
        color = if (model.following) ButtonColor else LightGrey
      ),
      contentPadding = PaddingValues(0.dp)
    ) {
      Text(text = if (model.following) "Following" else " Follow ", fontSize = 12.sp)
    }
  }
}