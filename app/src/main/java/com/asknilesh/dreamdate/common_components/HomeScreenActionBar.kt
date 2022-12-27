package com.asknilesh.dreamdate.common_components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddBox
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.asknilesh.dreamdate.R
import com.asknilesh.dreamdate.ui.theme.LightGrey

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable fun HomeScreenActionBar(
  onAddPostClick: () -> Unit = {},
  onNotificationClick: () -> Unit = {},
) {
  TopAppBar(
    title = {
      Column {
        Text(
          text = stringResource(id = R.string.app_name),
          color = Companion.White,
          fontSize = 20.sp,
          fontWeight = FontWeight.Bold
        )
        Text(
          text = "Welcome user!",
          color = LightGrey,
          fontSize = 14.sp,
        )
      }
    },
    actions = {
      IconButton(onClick = { onAddPostClick.invoke() }) {
        Icon(imageVector = Icons.Outlined.AddBox, contentDescription = "Add Post")
      }
      IconButton(onClick = { onNotificationClick.invoke() }) {
        Icon(imageVector = Icons.Outlined.Notifications, contentDescription = "Notifications")
      }
    },
    colors = TopAppBarDefaults.topAppBarColors(
      containerColor = Color.Black,
      actionIconContentColor = Color.White
    )
  )
}