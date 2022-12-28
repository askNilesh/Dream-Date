package com.asknilesh.dreamdate.screens.notification

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter.State.Error
import coil.compose.AsyncImagePainter.State.Loading
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.asknilesh.dreamdate.ui.theme.LightGrey

@Composable
@Preview
fun NotificationItem(
  model: NotificationModel = NotificationModel(
    notificationType = FollowNotification,
    userName = "lil_cutie",
    userImage = "https://images.unsplash.com/photo-1621317911081-f123294e86c7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OHx8Z2lybCUyMGFsb25lfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60",
    time = "5 seconds ago",
  ),
) {
  Column(modifier = Modifier
    .fillMaxWidth()
    .padding(horizontal = 0.dp, vertical = 2.dp)) {
    Spacer(modifier = Modifier.width(10.dp))
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp), verticalAlignment = Alignment.CenterVertically
    ) {
      SubcomposeAsyncImage(
        model = model.userImage,
        contentDescription = null,
        modifier = Modifier
          .width(50.dp)
          .height(50.dp)
          .clip(CircleShape)
          .border(
            border = BorderStroke(width = 1.dp, color = Color.White),
            shape = CircleShape
          ),
        contentScale = ContentScale.Inside,
      ) {
        val state = painter.state
        if (state is Loading || state is Error) {
          CircularProgressIndicator(
            color = Color.White,
            modifier = Modifier.height(50.dp)
          )
        } else {
          SubcomposeAsyncImageContent()
        }
      }
      Spacer(modifier = Modifier.width(10.dp))
      Column(modifier = Modifier.fillMaxWidth()
        .weight(1f)) {
        when (model.notificationType) {
          FollowNotification -> getNotificationText(
            userName = model.userName,
            notificationMessage = "started following you."
          )
          PostCommentNotification -> getNotificationText(
            userName = model.userName,
            notificationMessage = "commented your post."
          )
          PostLikeNotification -> getNotificationText(
            userName = model.userName,
            notificationMessage = "liked your post."
          )
        }
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = model.time, color = LightGrey, fontSize = 14.sp)
      }

      if(model.notificationType is PostLikeNotification ||
        model.notificationType is PostCommentNotification){
        SubcomposeAsyncImage(
          model = model.postImage,
          contentDescription = null,
          modifier = Modifier
            .width(50.dp)
            .height(50.dp)
            .clip(RoundedCornerShape(10.dp))
            .border(
              border = BorderStroke(width = 0.dp, color = Color.White),
              shape = RoundedCornerShape(10.dp)
            ),
          contentScale = ContentScale.Crop,
        ) {
          val state = painter.state
          if (state is Loading || state is Error) {
            CircularProgressIndicator(
              color = Color.White,
              modifier = Modifier.height(30.dp)
            )
          } else {
            SubcomposeAsyncImageContent()
          }
        }
      }

    }
    Spacer(modifier = Modifier.height(5.dp))
    Divider(color = LightGrey, thickness = 0.5.dp)
  }
}

@Composable
@Preview
fun getNotificationText(
  userName: String = "Marcus Aminoff",
  notificationMessage: String = "started following you."
) {

  Text(text = buildAnnotatedString {
    withStyle(
      SpanStyle(
        color = Color.White,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
      )
    ) {
      append(userName)
      append(" ")
    }
    withStyle(
      SpanStyle(
        color = Color.White,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
      )
    ) {
      append(notificationMessage)
    }

  })
}

sealed class NotificationType
object FollowNotification : NotificationType()
object PostLikeNotification : NotificationType()
object PostCommentNotification : NotificationType()

data class NotificationModel(
  val notificationType: NotificationType,
  val userName: String,
  val userImage: String,
  val time: String,
  val postImage: String? = null
)

fun getNotificationList() = listOf(
  NotificationModel(
    notificationType = FollowNotification,
    userName = "lil_cutie",
    userImage = "https://images.unsplash.com/photo-1621317911081-f123294e86c7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OHx8Z2lybCUyMGFsb25lfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60",
    time = "5 seconds ago",
  ),

  NotificationModel(
    notificationType = PostLikeNotification,
    userName = "superb_guy",
    userImage = "https://images.unsplash.com/photo-1589874186480-ecd085096d68?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzV8fGJveSUyMGFsb25lfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60",
    time = "5 seconds ago",
    postImage = "https://images.unsplash.com/photo-1474511320723-9a56873867b5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8YW5pbWFsfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60"
  ),
  NotificationModel(
    notificationType = PostCommentNotification,
    userName = "beauty.babe",
    userImage = "https://images.unsplash.com/photo-1621012430307-b4774b78d3cb?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8Z2lybCUyMGFsb25lfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60",
    time = "5 seconds ago",
    postImage = "https://images.unsplash.com/photo-1555169062-013468b47731?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8YW5pbWFsfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60"
  ),
  NotificationModel(
    notificationType = FollowNotification,
    userName = "ghost_rider",
    userImage = "https://images.unsplash.com/photo-1617868186608-87ae5c6f422c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTB8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
    time = "5 seconds ago",
  ),
  NotificationModel(
    notificationType = PostLikeNotification,
    userName = "instafreack",
    userImage = "https://images.unsplash.com/photo-1504279328919-cb04cd3be99b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTh8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
    time = "5 seconds ago",
    postImage = "https://images.unsplash.com/photo-1490718720478-364a07a997cd?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NzB8fGFuaW1hbHxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60"
  ),
  NotificationModel(
    notificationType = PostCommentNotification,
    userName = "romantic_boy",
    userImage = "https://images.unsplash.com/photo-1621004368144-7ce167331e2a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NDd8fGJveSUyMGFsb25lfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60",
    time = "5 seconds ago",
    postImage = "https://images.unsplash.com/photo-1543946207-39bd91e70ca7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTB8fGFuaW1hbHxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60"
  ),
  NotificationModel(
    notificationType = FollowNotification,
    userName = "dilokirani",
    userImage = "https://images.unsplash.com/photo-1619855515064-d32bc5e68b2c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mjd8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
    time = "5 seconds ago",
  ),
  NotificationModel(
    notificationType = PostLikeNotification,
    userName = "girlyapa",
    userImage = "https://images.unsplash.com/photo-1564046247017-4462f3c1e9f3?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NTh8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
    time = "5 seconds ago",
    postImage = "https://images.unsplash.com/photo-1425082661705-1834bfd09dca?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTR8fGFuaW1hbHxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60"
  ),
  NotificationModel(
    notificationType = FollowNotification,
    userName = "lil_cutie",
    userImage = "https://images.unsplash.com/photo-1621317911081-f123294e86c7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OHx8Z2lybCUyMGFsb25lfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60",
    time = "5 seconds ago",
    postImage = "https://images.unsplash.com/photo-1585110396000-c9ffd4e4b308?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MjF8fGFuaW1hbHxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60"
  ),

  NotificationModel(
    notificationType = PostLikeNotification,
    userName = "superb_guy",
    userImage = "https://images.unsplash.com/photo-1589874186480-ecd085096d68?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzV8fGJveSUyMGFsb25lfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60",
    time = "5 seconds ago",
    postImage = "https://images.unsplash.com/photo-1586959140255-aab0163e21cf?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MjR8fGFuaW1hbHxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60"
  ),
  NotificationModel(
    notificationType = PostCommentNotification,
    userName = "beauty.babe",
    userImage = "https://images.unsplash.com/photo-1621012430307-b4774b78d3cb?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8Z2lybCUyMGFsb25lfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60",
    time = "5 seconds ago",
    postImage = "https://images.unsplash.com/photo-1547721064-da6cfb341d50?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mjd8fGFuaW1hbHxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60"
  ),
  NotificationModel(
    notificationType = FollowNotification,
    userName = "ghost_rider",
    userImage = "https://images.unsplash.com/photo-1617868186608-87ae5c6f422c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTB8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
    time = "5 seconds ago",
  ),
  NotificationModel(
    notificationType = PostLikeNotification,
    userName = "instafreack",
    userImage = "https://images.unsplash.com/photo-1504279328919-cb04cd3be99b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTh8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
    time = "5 seconds ago",
    postImage = "https://images.unsplash.com/photo-1589656966895-2f33e7653819?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzJ8fGFuaW1hbHxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60"
  ),
  NotificationModel(
    notificationType = PostCommentNotification,
    userName = "romantic_boy",
    userImage = "https://images.unsplash.com/photo-1621004368144-7ce167331e2a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NDd8fGJveSUyMGFsb25lfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60",
    time = "5 seconds ago",
    postImage = "https://images.unsplash.com/photo-1537151608828-ea2b11777ee8?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzN8fGFuaW1hbHxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60"
  ),
  NotificationModel(
    notificationType = FollowNotification,
    userName = "dilokirani",
    userImage = "https://images.unsplash.com/photo-1619855515064-d32bc5e68b2c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mjd8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
    time = "5 seconds ago",
  ),
  NotificationModel(
    notificationType = PostLikeNotification,
    userName = "girlyapa",
    userImage = "https://images.unsplash.com/photo-1564046247017-4462f3c1e9f3?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NTh8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
    time = "5 seconds ago",
    postImage = "https://images.unsplash.com/photo-1507666405895-422eee7d517f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NDJ8fGFuaW1hbHxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60"
  ),
  NotificationModel(
    notificationType = FollowNotification,
    userName = "lil_cutie",
    userImage = "https://images.unsplash.com/photo-1621317911081-f123294e86c7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OHx8Z2lybCUyMGFsb25lfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60",
    time = "5 seconds ago",
  ),

  NotificationModel(
    notificationType = PostLikeNotification,
    userName = "superb_guy",
    userImage = "https://images.unsplash.com/photo-1589874186480-ecd085096d68?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzV8fGJveSUyMGFsb25lfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60",
    time = "5 seconds ago",
    postImage = "https://images.unsplash.com/photo-1534188753412-3e26d0d618d6?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NDV8fGFuaW1hbHxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60"
  ),
  NotificationModel(
    notificationType = PostCommentNotification,
    userName = "beauty.babe",
    userImage = "https://images.unsplash.com/photo-1621012430307-b4774b78d3cb?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8Z2lybCUyMGFsb25lfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60",
    time = "5 seconds ago",
    postImage = "https://images.unsplash.com/photo-1558954350-2bc4ea82347f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NDZ8fGFuaW1hbHxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60"
  ),
  NotificationModel(
    notificationType = FollowNotification,
    userName = "ghost_rider",
    userImage = "https://images.unsplash.com/photo-1617868186608-87ae5c6f422c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTB8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
    time = "5 seconds ago",
  ),
  NotificationModel(
    notificationType = PostLikeNotification,
    userName = "instafreack",
    userImage = "https://images.unsplash.com/photo-1504279328919-cb04cd3be99b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTh8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
    time = "5 seconds ago",
    postImage = "https://images.unsplash.com/photo-1590079015089-875baa76cc8d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NTl8fGFuaW1hbHxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60"
  ),
  NotificationModel(
    notificationType = PostCommentNotification,
    userName = "romantic_boy",
    userImage = "https://images.unsplash.com/photo-1621004368144-7ce167331e2a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NDd8fGJveSUyMGFsb25lfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60",
    time = "5 seconds ago",
    postImage = "https://images.unsplash.com/photo-1583337130417-3346a1be7dee?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NjB8fGFuaW1hbHxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60"
  ),
  NotificationModel(
    notificationType = FollowNotification,
    userName = "dilokirani",
    userImage = "https://images.unsplash.com/photo-1619855515064-d32bc5e68b2c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mjd8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
    time = "5 seconds ago",
  ),
  NotificationModel(
    notificationType = PostLikeNotification,
    userName = "girlyapa",
    userImage = "https://images.unsplash.com/photo-1564046247017-4462f3c1e9f3?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NTh8fGdpcmwlMjBhbG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60",
    time = "5 seconds ago",
    postImage = "https://images.unsplash.com/photo-1497119146420-012f8fc80a3a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NTF8fGFuaW1hbHxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=800&q=60"
  ),
)