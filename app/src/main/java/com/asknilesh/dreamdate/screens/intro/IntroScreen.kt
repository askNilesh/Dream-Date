package com.asknilesh.dreamdate.screens.intro

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.asknilesh.dreamdate.common_components.PageIndicator
import com.asknilesh.dreamdate.navigation.DreamDateScreens

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun IntroScreen(navController: NavController) {

  Scaffold(
    containerColor = Color.Black
  ) { paddingValues ->
    val pagerState = rememberPagerState()

    Column(
      horizontalAlignment = Alignment.End
    ) {
      HorizontalPager(
        pageCount = 3,
        state = pagerState,
        modifier = Modifier
          .fillMaxWidth()
          .weight(1f)
      ) {
        IntroPageItem()
      }

      PageIndicator(
        numberOfPages = 3,
        selectedPage = pagerState.currentPage,
        defaultRadius = 5.dp,
        selectedLength = 40.dp,
        space = 10.dp,
        animationDurationInMillis = 300,
        defaultColor = Color.DarkGray,
        selectedColor = Color.White,
        modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
      )
      Text(
        "Skip", color = Color.White, fontSize = 18.sp,
        modifier = Modifier
          .padding(horizontal = 20.dp)
          .clickable {
            navController.navigate(DreamDateScreens.LOGIN_SCREEN.name) {
              popUpTo(DreamDateScreens.INTRO_SCREEN.name) {
                inclusive = true
              }
            }
          }
      )

    }
  }
}