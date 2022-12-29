package com.asknilesh.dreamdate.screens.user_profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons.Outlined
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun UserPostList() {
  LazyVerticalGrid(
    columns = GridCells.Fixed(2),

    ) {
    items(getPostList()) { model ->
      Box(contentAlignment = Alignment.TopEnd) {
        AsyncImage(
          model = model.userImage,
          contentDescription = null,
          modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
          contentScale = ContentScale.Crop
        )

        Column(modifier = Modifier.padding(top = 10.dp)) {
          Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
              .clip(RoundedCornerShape(5.dp))
              .background(Color(0x6A85868B))
              .padding(horizontal = 5.dp, vertical = 2.dp)
          ) {
            Icon(
              imageVector = Outlined.Visibility, contentDescription = "",
              tint = Color.White
            )
            Text(
              text = model.viewCount,
              modifier = Modifier
                .padding(horizontal = 5.dp, vertical = 5.dp),
              color = Color.White,
              fontSize = 12.sp,
            )

          }
        }
      }
    }
  }
}

data class PostModel(
  val userImage: String,
  val viewCount: String
)

fun getPostList() = mutableListOf(
  PostModel(
    userImage = "https://images.unsplash.com/photo-1529252233991-9ea40cd5ab41?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzV8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
    viewCount = "22.5K"
  ),
  PostModel(
    userImage = "https://images.unsplash.com/photo-1600523863597-63967a1c0b10?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mzl8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
    viewCount = "22.5K"
  ),
  PostModel(
    userImage = "https://images.unsplash.com/photo-1616991019655-b1d6ab71476a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NDZ8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
    viewCount = "22K"
  ),
  PostModel(
    userImage = "https://images.unsplash.com/photo-1613287673032-e7129d1bcda4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NDd8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
    viewCount = "34K"
  ), PostModel(
    userImage = "https://images.unsplash.com/photo-1620878560351-3b5626c75190?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NTN8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
    viewCount = "344K"
  ), PostModel(
    userImage = "https://images.unsplash.com/photo-1616961961091-a83cbe49116b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NjJ8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
    viewCount = "33K"
  ),

  PostModel(
    userImage = "https://images.unsplash.com/photo-1611567149614-74b77f482488?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NzR8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
    viewCount = "344K"
  ), PostModel(
    userImage = "https://images.unsplash.com/photo-1532308787675-c690de917ec9?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8ODh8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
    viewCount = "334K"
  ), PostModel(
    userImage = "https://images.unsplash.com/photo-1624006388834-fd14301548d0?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OTJ8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
    viewCount = "84K"
  ),
  PostModel(
    userImage = "https://images.unsplash.com/photo-1620523233793-1b1379f397c5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTAyfHxnaXJsJTIwYWxvbmV8ZW58MHx8MHx8&auto=format&fit=crop&w=800&q=60",
    viewCount = "234K"
  ),
  PostModel(
    userImage = "https://images.unsplash.com/photo-1615880782533-562293fc8eb3?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTE3fHxnaXJsJTIwYWxvbmV8ZW58MHx8MHx8&auto=format&fit=crop&w=800&q=60",
    viewCount = "20K"
  ), PostModel(
    userImage = "https://images.unsplash.com/photo-1612751747121-543c0be0f58f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTI2fHxnaXJsJTIwYWxvbmV8ZW58MHx8MHx8&auto=format&fit=crop&w=800&q=60",
    viewCount = "40K"
  ),
  PostModel(
    userImage = "https://images.unsplash.com/photo-1524088484081-4ca7e08e3e19?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTQ4fHxnaXJsJTIwYWxvbmV8ZW58MHx8MHx8&auto=format&fit=crop&w=800&q=60",
    viewCount = "45K"
  ),

  PostModel(
    userImage = "https://images.unsplash.com/photo-1587345136683-245016012e86?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTQ2fHxnaXJsJTIwYWxvbmV8ZW58MHx8MHx8&auto=format&fit=crop&w=800&q=60",
    viewCount = "100K"
  )

)