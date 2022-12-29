package com.asknilesh.dreamdate.screens.user_profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import androidx.navigation.NavController
import coil.compose.AsyncImagePainter.State.Error
import coil.compose.AsyncImagePainter.State.Loading
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.asknilesh.dreamdate.navigation.DreamDateScreens.USER_FOLLOWERS_SCREEN
import com.asknilesh.dreamdate.ui.theme.ButtonColor

const val userImage =
  "https://images.unsplash.com/photo-1626818590242-5a5f27ee3971?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTd8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60"

@Composable
@Preview
fun ProfileDetailsSection(navController: NavController) {
  Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
  ) {
    SubcomposeAsyncImage(
      model = userImage,
      contentDescription = null,
      modifier = Modifier
        .width(80.dp)
        .height(80.dp)
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
          modifier = Modifier.height(80.dp)
        )
      } else {
        SubcomposeAsyncImageContent()
      }
    }
    BuildProfileDetail(title = "225", body = "Posts")
    BuildProfileDetail(title = "300", body = "Following") {
      navController.navigate(USER_FOLLOWERS_SCREEN.name)
    }
    BuildProfileDetail(title = "500K", body = "Followers") {
      navController.navigate(USER_FOLLOWERS_SCREEN.name)
    }
  }
}

@Preview
@Composable
fun BuildProfileDetail(
  title: String = "226",
  body: String = "Posts",
  onClick: () -> Unit = {}
) {
  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
    modifier = Modifier.clickable {
      onClick.invoke()
    }
  ) {
    Text(text = title, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
    Spacer(modifier = Modifier.height(5.dp))
    Text(text = body, color = Color.LightGray, fontSize = 16.sp)
  }
}