package com.asknilesh.dreamdate.screens.explore

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.asknilesh.dreamdate.R.drawable

@OptIn(ExperimentalMaterial3Api::class)
@Composable fun ExploreScreenActionBar(
  scrollBehavior: TopAppBarScrollBehavior,
  onFilterIconClick: () -> Unit = {}
) {
  TopAppBar(
    title = {
      Column {
        Text(
          text = "Explore",
          color = Companion.White,
          fontSize = 20.sp,
          fontWeight = FontWeight.Bold
        )
      }
    },
    actions = {
      IconButton(onClick = { onFilterIconClick.invoke() }) {
        Icon(painter = painterResource(id = drawable.ic_filter), contentDescription = "Add Post")
      }
    },
    colors = TopAppBarDefaults.topAppBarColors(
      containerColor = Color.Black,
      actionIconContentColor = Color.White
    ),
    scrollBehavior = scrollBehavior
  )
}