package com.asknilesh.dreamdate.screens.profile

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileActionBar(
  scrollBehavior: TopAppBarScrollBehavior,
  onMoreIconClick: () -> Unit,
) {
  CenterAlignedTopAppBar(
    title = { Text(text = "lil_cutie") },
    actions = {
      IconButton(onClick = { onMoreIconClick.invoke() }) {
        Icon(imageVector = Icons.Default.Menu, contentDescription = "More")
      }
    },
    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
      containerColor = Color.Black,
      actionIconContentColor = Color.White,
      navigationIconContentColor = Color.White,
      titleContentColor = Color.White
    ),
    scrollBehavior = scrollBehavior
  )
}