package com.asknilesh.dreamdate.screens.short

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.asknilesh.dreamdate.model.getShortsList

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShortsScreen(navController: NavController) {
  val shortsList = getShortsList()

  Scaffold(
    modifier = Modifier
      .fillMaxWidth()
      .fillMaxHeight(),
    containerColor = Color.Black
  ) {
    LazyColumn(
      modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
    ) {
      items(shortsList) { model ->
        ShortCard(model)
      }
    }
  }
}