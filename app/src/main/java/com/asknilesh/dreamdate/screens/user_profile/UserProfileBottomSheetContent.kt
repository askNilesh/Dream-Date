package com.asknilesh.dreamdate.screens.user_profile

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.asknilesh.dreamdate.R

@Composable
fun UserProfileBottomSheetContent() {
  val context = LocalContext.current


  Column( modifier = Modifier
    .fillMaxWidth()
    .wrapContentHeight()
    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
    .background(Color(0xff1A1A27))
    .padding(horizontal = 20.dp)) {
    Spacer(modifier = Modifier.height(20.dp))
    BottomSheetListItem(
      icon = R.drawable.ic_report,
      title = "Report @lil_cutie",
      textColor = Color(0xFFEB5757),
      onItemClick = { title ->
        Toast.makeText(
          context,
          title,
          Toast.LENGTH_SHORT
        ).show()
      })
    BottomSheetListItem(
      icon = R.drawable.ic_block,
      title = "Block @lil_cutie",
      onItemClick = { title ->
        Toast.makeText(
          context,
          title,
          Toast.LENGTH_SHORT
        ).show()
      })
    BottomSheetListItem(
      icon = R.drawable.ic_send,
      title = "Share Profile",
      onItemClick = { title ->
        Toast.makeText(
          context,
          title,
          Toast.LENGTH_SHORT
        ).show()
      })
    Spacer(modifier = Modifier.height(50.dp))
  }
}

@Composable
fun BottomSheetListItem(
  icon: Int,
  title: String,
  textColor: Color = Color.White,
  onItemClick: (String) -> Unit
) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .clickable(onClick = { onItemClick(title) })
      .height(55.dp)
      .padding(start = 15.dp), verticalAlignment = Alignment.CenterVertically
  ) {
    Image(painter = painterResource(id = icon), contentDescription = title)
    Spacer(modifier = Modifier.width(20.dp))
    Text(text = title, color = textColor)
  }
}