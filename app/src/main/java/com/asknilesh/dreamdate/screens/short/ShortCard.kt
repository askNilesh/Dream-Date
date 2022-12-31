package com.asknilesh.dreamdate.screens.short

import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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
  ),
  onCommentIconClick : () -> Unit = {},
  onLikeIconClick : () -> Unit = {},
  onMoreIconClick : () -> Unit = {},
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
    Row(modifier = Modifier.fillMaxWidth()) {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .weight(1f)
          .align(alignment = Alignment.Bottom)
      ) {
        BuildBottomSection(model)
        Text(
          text = model.caption, color = Color.White,
          fontSize = 16.sp, fontWeight = FontWeight.Bold,
          modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
      }
      Column {
        BuildImageWithTextView(
          imageVector = Icons.Default.FavoriteBorder,
          text = model.likes
        )
        BuildImageWithTextView(
          imageVector = Icons.Default.Comment,
          text = model.comments
        )
        IconButton(
          onClick = { onMoreIconClick.invoke() },
        ) {
          Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "",
            tint = Color.White
          )
        }

        Spacer(modifier = Modifier.height(50.dp))
      }
    }
  }
}

@Composable
fun BuildBottomSection(
  model: ShortsModel,
) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 10.dp, vertical = 0.dp),
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
        .wrapContentWidth()
        .padding(horizontal = 10.dp)
    ) {
      Row {
        Text(
          text = model.userName, color = Color.White,
          fontSize = 14.sp, fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.width(10.dp))
        if (!model.following) {
          Text(
            text = "Follow ",
            color = Color.White,
            fontSize = 10.sp,
            modifier = Modifier
              .background(color = ButtonColor, shape = RoundedCornerShape(5.dp))
              .padding(5.dp)
          )
        }
      }
      Text(
        text = "12k Followers", color = Color.White,
        fontSize = 12.sp
      )
    }

  }
}

@Composable
fun BuildImageWithTextView(
  imageVector: ImageVector = Icons.Default.FavoriteBorder,
  text: String = "12K"
) {
  Column(
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    IconButton(
      onClick = { /*TODO*/ },
    ) {
      Icon(
        imageVector = imageVector,
        contentDescription = "",
        tint = Color.White
      )
    }
    Text(text = text, color = Color.White)
  }
}