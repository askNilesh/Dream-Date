package com.asknilesh.dreamdate.screens.live

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent

// const val imageUrl = "https://images.unsplash.com/photo-1619855515064-d32bc5e68b2c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mjh8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60"
const val imageUrl =
  "https://images.unsplash.com/photo-1542303364-399a3156414d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Njl8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60"
// const val imageUrl = "https://images.unsplash.com/photo-1532308787675-c690de917ec9?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8ODh8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60"

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserLiveScreen(navController: NavController) {

  Box(modifier = Modifier) {
    SubcomposeAsyncImage(
      model = imageUrl,
      contentDescription = null,
      modifier = Modifier
        .matchParentSize(),
      contentScale = ContentScale.FillHeight,
    ) {
      SubcomposeAsyncImageContent()
    }
    Scaffold(
      containerColor = Color.Transparent,
    ) {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .fillMaxHeight()
          .padding(vertical = 30.dp, horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
      ) {
        LiveScreenActionBar(navController)
        Column(modifier = Modifier.fillMaxWidth()) {
          LiveCommentSection()
          Spacer(modifier = Modifier.height(20.dp))
          LiveBottomSection(navController)
        }
      }

    }
  }
}


