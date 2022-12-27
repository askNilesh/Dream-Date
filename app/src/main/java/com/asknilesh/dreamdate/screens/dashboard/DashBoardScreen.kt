package com.asknilesh.dreamdate.screens.dashboard

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons.Outlined
import androidx.compose.material.icons.outlined.Videocam
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.asknilesh.dreamdate.common_components.AnimateTextStyleAsState
import com.asknilesh.dreamdate.common_components.HomeScreenActionBar
import com.asknilesh.dreamdate.screens.dashboard.CurrentTab.Following
import com.asknilesh.dreamdate.screens.dashboard.CurrentTab.ForYou
import com.asknilesh.dreamdate.ui.theme.ButtonColor
import com.asknilesh.dreamdate.ui.theme.LightGrey
import com.google.accompanist.pager.ExperimentalPagerApi

enum class CurrentTab {
  ForYou,
  Following;
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPagerApi::class)
@Composable
@Preview
fun DashBoardScreen(navController: NavHostController = NavHostController(LocalContext.current)) {

  val selectedContentType = remember {
    mutableStateOf(ForYou)
  }

  val appBarState = rememberTopAppBarState()

  val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())


  Scaffold(
    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
    topBar = { HomeScreenActionBar(scrollBehavior = scrollBehavior) },
    containerColor = Color.Black,
    floatingActionButtonPosition = FabPosition.Center,
    floatingActionButton = {
      FloatingActionButton(
        onClick = { },
        shape = CircleShape,
        containerColor = ButtonColor,
      ) {
        Icon(
          imageVector = Outlined.Videocam, contentDescription = "Video",
          tint = Color.White
        )
      }
    },
  ) { innerPadding ->
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(innerPadding)
    ) {
      Spacer(modifier = Modifier.height(0.dp))
      BuildHeaderTabsSection(selectedContentType)
      Spacer(modifier = Modifier.height(10.dp))
      when (selectedContentType.value) {
        ForYou -> DashBoardForYouScreen(navController = navController)
        Following -> DashBoardFollowingScreen()
      }
    }

  }
}

@Composable
fun BuildHeaderTabsSection(
  selectedContentType: MutableState<CurrentTab>
) {
  val animatedTextStyle by AnimateTextStyleAsState(
    targetValue = TextStyle(
      color = Color.White,
      fontWeight = FontWeight.ExtraBold,
      fontSize = 25.sp
    ),
    animationSpec = tween(durationMillis = 1300, easing = LinearEasing)
  )
  val defaultStyle by AnimateTextStyleAsState(
    targetValue = TextStyle(
      color = LightGrey,
      fontWeight = FontWeight.Normal,
      fontSize = 18.sp
    ),
    animationSpec = tween(durationMillis = 1300, easing = LinearEasing)
  )
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 15.dp),
    horizontalArrangement = Arrangement.Start,
    verticalAlignment = Alignment.CenterVertically
  ) {
    ClickableText(
      text = AnnotatedString("For You"),
      onClick = {
        selectedContentType.value = ForYou
      },
      style = if (selectedContentType.value == ForYou)
        animatedTextStyle
      else defaultStyle,
      // modifier = Modifier.animateContentSize()
    )
    Spacer(modifier = Modifier.width(20.dp))
    ClickableText(
      onClick = {
        selectedContentType.value = Following
      },
      text = AnnotatedString("Following"),
      style = if (selectedContentType.value == Following)
        animatedTextStyle
      else defaultStyle,
    )
  }
}
