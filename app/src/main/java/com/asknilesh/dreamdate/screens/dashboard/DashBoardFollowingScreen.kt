package com.asknilesh.dreamdate.screens.dashboard

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells.Fixed
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons.Outlined
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter.State.Error
import coil.compose.AsyncImagePainter.State.Loading
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.asknilesh.dreamdate.common_components.circularReveal
import com.asknilesh.dreamdate.model.FollowingModel
import com.asknilesh.dreamdate.model.getFollowingList
import com.asknilesh.dreamdate.navigation.DreamDateScreens
import com.asknilesh.dreamdate.ui.theme.ButtonColor
import com.asknilesh.dreamdate.ui.theme.CallButtonColor

@Composable
fun DashBoardFollowingScreen(navController: NavController) {
  val models = getFollowingList()
  LazyVerticalGrid(columns = Fixed(2)) {
    items(models) { model ->
      BuildForYouCard(model) {
        navController.navigate(DreamDateScreens.LIVE_SCREEN.name)
      }
    }
  }
}

@Preview
@Composable
fun BuildForYouCard(
  model: FollowingModel = FollowingModel(
    userName = "lil_cutie",
    totalFollower = "12K followers",
    liveUserCount = "3.8K",
    isLive = true,
    userImage = "https://images.unsplash.com/photo-1621317911081-f123294e86c7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OHx8Z2lybCUyMGFsb25lfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60",
    posterImage = "https://images.unsplash.com/photo-1619855544858-e8e275c3b31a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8Z2lybCUyMGFsb25lfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60",
  ),
  onCardClick: () -> Unit = {}
) {

  Box(modifier = Modifier
    .padding(2.dp)
    .clickable {
      onCardClick.invoke()
    }) {
    AsyncImage(
      model = model.posterImage,
      contentDescription = null,
      modifier = Modifier
        .circularReveal(visible = true)
        .fillMaxWidth()
        .height(200.dp),
      contentScale = ContentScale.Crop
    )
    Column(
      verticalArrangement = Arrangement.SpaceBetween,
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier
        .height(200.dp)
    ) {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(5.dp),
        horizontalArrangement = Arrangement.SpaceBetween
      ) {
        if (model.isLive) {
          Text(
            text = "Live",
            modifier = Modifier
              .clip(RoundedCornerShape(5.dp))
              .background(Color(0xffEB5757))
              .padding(horizontal = 10.dp, vertical = 5.dp),
            color = Color.White,
            fontSize = 12.sp,
          )
        } else {
          Spacer(modifier = Modifier.height(10.dp))
        }

        Row(
          verticalAlignment = Alignment.CenterVertically,
          modifier = Modifier
            .clip(RoundedCornerShape(5.dp))
            .background(Color(0x6A85868B))
            .padding(horizontal = 5.dp, vertical = 2.dp)
        ) {
          Icon(
            imageVector = Outlined.Visibility, contentDescription = "Live",
            tint = Color.White
          )
          Text(
            text = model.liveUserCount,
            modifier = Modifier
              .padding(horizontal = 5.dp, vertical = 5.dp),
            color = Color.White,
            fontSize = 12.sp,
          )

        }
      }



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
        Column(
          modifier = Modifier.weight(1f)
        ) {
          Text(
            text = model.userName, color = Color.White,
            fontSize = 14.sp,
          )
          Text(
            text = model.totalFollower, color = Color.White,
            fontSize = 12.sp,
          )
        }
        FloatingActionButton(
          onClick = { },
          shape = CircleShape,
          containerColor = CallButtonColor,
          modifier = Modifier
            .width(30.dp)
            .height(30.dp)
            .clip(CircleShape)
        ) {
          Icon(
            imageVector = Outlined.Call, contentDescription = "Call",
            tint = Color.White,
            modifier = Modifier.size(20.dp)
          )
        }
        Spacer(modifier = Modifier.width(5.dp))

      }
    }
  }
}