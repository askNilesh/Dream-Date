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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.asknilesh.dreamdate.model.ForYouModel
import com.asknilesh.dreamdate.model.getForYouPageList
import com.asknilesh.dreamdate.navigation.DreamDateScreens
import com.asknilesh.dreamdate.ui.theme.ButtonColor
import com.asknilesh.dreamdate.ui.theme.LightGrey

@Composable
fun DashBoardForYouScreen(navController: NavController) {
  val models = getForYouPageList()
  LazyVerticalGrid(columns = GridCells.Fixed(2)) {
    items(models) { model ->
      BuildForYouCard(model) {
        navController.navigate(DreamDateScreens.LIVE_SCREEN.name)
      }
    }
  }
}

@Composable
fun BuildForYouCard(
  model: ForYouModel,
  onCardClick: () -> Unit = {}
) {

  Box(modifier = Modifier.padding(2.dp)
    .clickable {
      onCardClick.invoke()
    }) {
    AsyncImage(
      model = model.posterImage,
      contentDescription = null,
      modifier = Modifier
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
      if (model.isLive) {
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
          horizontalArrangement = Arrangement.SpaceBetween
        ) {
          Text(
            text = "Live",
            modifier = Modifier
              .clip(RoundedCornerShape(5.dp))
              .background(Color(0xffEB5757))
              .padding(horizontal = 10.dp, vertical = 5.dp),
            color = Color.White,
            fontSize = 12.sp,
          )

          Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
              .clip(RoundedCornerShape(5.dp))
              .background(Color(0x6A85868B))
              .padding(horizontal = 5.dp, vertical = 2.dp)
          ) {
            Icon(
              imageVector = Icons.Outlined.Visibility, contentDescription = "Live",
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
      } else {
        Spacer(modifier = Modifier.height(10.dp))
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
          if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
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
            text = model.userName, color = Color.White,
            fontSize = 14.sp,
          )
          Text(
            text = model.totalFollower, color = LightGrey,
            fontSize = 12.sp,
          )
        }
      }
    }
  }
}