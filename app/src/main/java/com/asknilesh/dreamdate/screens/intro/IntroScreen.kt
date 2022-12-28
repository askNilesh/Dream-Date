package com.asknilesh.dreamdate.screens.intro

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.asknilesh.dreamdate.common_components.CommonButton
import com.asknilesh.dreamdate.common_components.PageIndicator
import com.asknilesh.dreamdate.navigation.DreamDateScreens
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(
  ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class,
  ExperimentalPagerApi::class
)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun IntroScreen(navController: NavController) {

  val scope = rememberCoroutineScope()
  Scaffold(
    containerColor = Color.Black
  ) { paddingValues ->
    val pagerState = rememberPagerState()

    val showButton = remember(pagerState.currentPage) {
      pagerState.currentPage == 4
    }
    Column(
      horizontalAlignment = Alignment.End
    ) {
      HorizontalPager(
        count = 5,
        state = pagerState,
        modifier = Modifier
          .fillMaxWidth()
          .weight(1f)
      ) {
        IntroPageItem()
      }

      PageIndicator(
        numberOfPages = 5,
        selectedPage = pagerState.currentPage,
        defaultRadius = 5.dp,
        selectedLength = 40.dp,
        space = 10.dp,
        animationDurationInMillis = 300,
        defaultColor = Color.DarkGray,
        selectedColor = Color.White,
        modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
      )

      Spacer(modifier = Modifier.height(20.dp))
      AnimatedVisibility(visible = showButton) {
        BuildBottomSection(navController)
      }

      AnimatedVisibility(visible = !showButton) {
        Row(
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically,
          modifier = Modifier.fillMaxWidth()
        ) {
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

          Text(
            "Next", color = Color.White, fontSize = 18.sp,
            modifier = Modifier
              .padding(horizontal = 20.dp)
              .clickable {
                scope.launch {
                  pagerState.animateScrollToPage(pagerState.currentPage + 1)
                }
              }
          )
        }
      }
      Spacer(modifier = Modifier.height(30.dp))
    }
  }
}

@Composable
fun BuildBottomSection(navController: NavController) {
  CommonButton(
    buttonText = "Continue", enabled = true,
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 40.dp),
  ) {
    navController.navigate(DreamDateScreens.LOGIN_SCREEN.name) {
      popUpTo(DreamDateScreens.INTRO_SCREEN.name) {
        inclusive = true
      }
    }

  }
}