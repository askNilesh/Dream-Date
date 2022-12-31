package com.asknilesh.dreamdate.screens.short

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.asknilesh.dreamdate.R.drawable
import com.asknilesh.dreamdate.screens.user_profile.BottomSheetListItem

@Composable
fun ShortsScreenBottomSheetContent() {
  val context = LocalContext.current

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .wrapContentHeight()
      .background(
        color = Color(0xff1A1A27),
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
      )
      .padding(horizontal = 10.dp, vertical = 20.dp)
  ) {
    Spacer(modifier = Modifier.height(20.dp))
    BottomSheetListItem(
      icon = drawable.ic_report,
      title = "Report...",
      textColor = Color(0xFFEB5757),
      onItemClick = { title ->
        Toast.makeText(
          context,
          title,
          Toast.LENGTH_SHORT
        ).show()
      })
    BottomSheetListItem(
      icon = drawable.ic_link,
      title = "Copy link",
      onItemClick = { title ->
        Toast.makeText(
          context,
          title,
          Toast.LENGTH_SHORT
        ).show()
      })
    BottomSheetListItem(
      icon = drawable.ic_send,
      title = "Share to...",
      onItemClick = { title ->
        Toast.makeText(
          context,
          title,
          Toast.LENGTH_SHORT
        ).show()
      })
    BottomSheetListItem(
      icon = drawable.ic_save,
      title = "Save",
      onItemClick = { title ->
        Toast.makeText(
          context,
          title,
          Toast.LENGTH_SHORT
        ).show()
      })
  }
}