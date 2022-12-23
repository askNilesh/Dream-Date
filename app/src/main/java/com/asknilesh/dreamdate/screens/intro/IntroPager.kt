package com.asknilesh.dreamdate.screens.intro

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.asknilesh.dreamdate.common_components.PageIndicator
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
@Composable
fun BuildIntroPager() {
  val pagerState = rememberPagerState()

  Column() {
    HorizontalPager(
      count = 3,
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

  }
}