package com.asknilesh.dreamdate.screens.short

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue.Hidden
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.asknilesh.dreamdate.model.getShortsList
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun ShortsScreen(navController: NavController) {
  val shortsList = getShortsList()

  val bottomSheetState = rememberModalBottomSheetState(initialValue = Hidden)
  val scope = rememberCoroutineScope()

  BackHandler(enabled = bottomSheetState.isVisible) {
    scope.launch {
      bottomSheetState.hide()
    }
  }

  ModalBottomSheetLayout(
    sheetContent = {
      ShortsScreenBottomSheetContent()
    },
    sheetState = bottomSheetState,
    sheetContentColor = Color(0xff1A1A27),
    sheetBackgroundColor = Color.Transparent,
    modifier = Modifier
      .fillMaxWidth()
      .fillMaxHeight()
  ) {
    Scaffold(
      modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),
      containerColor = Color.Black
    ) {
      LazyColumn(
        modifier = Modifier
          .fillMaxWidth()
          .fillMaxHeight(),
      ) {
        items(shortsList) { model ->
          ShortCard(
            model,
            onCommentIconClick = {
              scope.launch {
                bottomSheetState.show()
              }
            },
            onLikeIconClick = {
              scope.launch {
                bottomSheetState.show()
              }
            },
            onMoreIconClick = {
              scope.launch {
                bottomSheetState.show()
              }
            },
          )
        }
      }
    }
  }
}