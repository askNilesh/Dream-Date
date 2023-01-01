package com.asknilesh.dreamdate.common_components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun DreamDateImage() {
  val imageRequest = ImageRequest.Builder(LocalContext.current)
    .data("https://images.unsplash.com/photo-1619855544858-e8e275c3b31a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8Z2lybCUyMGFsb25lfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60")
    .listener(
      onStart = {

      },
      onSuccess = { request, metadata ->

      }
    )
    .build()

  AsyncImage(
    model = imageRequest,
    contentDescription = null,
    modifier = Modifier
      .fillMaxWidth()
      .height(200.dp)
      .circularReveal(visible = true),
    contentScale = ContentScale.Crop,
  )
}