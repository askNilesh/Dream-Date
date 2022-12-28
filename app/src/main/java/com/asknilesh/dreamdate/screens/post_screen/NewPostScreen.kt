package com.asknilesh.dreamdate.screens.post_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FlashAuto
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.SwitchCamera
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.asknilesh.dreamdate.ui.theme.LightGrey

const val imageUrl =
  "https://images.unsplash.com/photo-1612272361525-a50a032ea9c5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OXx8Z2lybCUyMGFsb25lfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun NewPostScreen(navController: NavController? = null) {

  Box {
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
      containerColor = Color.Transparent
    ) { paddingValues ->

      Column(
        modifier = Modifier
          .fillMaxWidth()
          .fillMaxHeight()
          .padding(paddingValues)
          .padding(horizontal = 20.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          IconButton(
            onClick = { navController?.popBackStack() },
            modifier = Modifier
              .width(30.dp)
              .height(30.dp)
              .clip(CircleShape)
              .background(LightGrey.copy(alpha = .2f))
          ) {
            Icon(
              imageVector = Icons.Default.Close,
              contentDescription = "Close",
              modifier = Modifier
                .width(30.dp)
                .height(30.dp)
                .clip(CircleShape),
              tint = Color.White
            )
          }
          IconButton(
            onClick = { },
            modifier = Modifier
              .width(30.dp)
              .height(30.dp)
              .clip(CircleShape)
              .background(LightGrey.copy(alpha = .2f))
          ) {
            Icon(
              imageVector = Icons.Default.FlashAuto,
              contentDescription = "FlashAuto",
              modifier = Modifier
                .width(30.dp)
                .height(30.dp)
                .clip(CircleShape),
              tint = Color.White
            )
          }

        }

        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          IconButton(
            onClick = { navController?.popBackStack() },
            modifier = Modifier
              .width(30.dp)
              .height(30.dp)
              .clip(CircleShape)
              .background(LightGrey.copy(alpha = .2f))
          ) {
            Icon(
              imageVector = Icons.Default.SwitchCamera,
              contentDescription = "SwitchCamera",
              modifier = Modifier
                .width(30.dp)
                .height(30.dp)
                .clip(CircleShape),
              tint = Color.White
            )
          }

          Box(
            modifier = Modifier
              .width(60.dp)
              .height(60.dp)
              .border(
                width = 2.dp,
                color = Color.White,
                shape = CircleShape
              )
              .clickable {  },
            contentAlignment = Alignment.Center
          ) {
            Box(
              modifier = Modifier
                .width(60.dp)
                .height(60.dp)
                .padding(5.dp)
                .clip(CircleShape)
                .background(Color.White)
            ) {

            }
          }
          IconButton(
            onClick = { },
            modifier = Modifier
              .width(30.dp)
              .height(30.dp)
              .clip(CircleShape)
              .background(LightGrey.copy(alpha = .2f))
          ) {
            Icon(
              imageVector = Icons.Default.Image,
              contentDescription = "Image",
              modifier = Modifier
                .width(30.dp)
                .height(30.dp)
                .clip(CircleShape),
              tint = Color.White
            )
          }

        }
      }
    }
  }
}