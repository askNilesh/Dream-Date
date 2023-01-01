package com.asknilesh.dreamdate.screens.followers

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.asknilesh.dreamdate.model.MyFollowerModel
import com.asknilesh.dreamdate.model.getMyFollowersList
import com.asknilesh.dreamdate.screens.followers.FollowersScreenTabs.FOLLOWERS
import com.asknilesh.dreamdate.screens.followers.FollowersScreenTabs.FOLLOWINGS
import com.asknilesh.dreamdate.ui.theme.ButtonColor
import com.asknilesh.dreamdate.ui.theme.LightGrey

enum class FollowersScreenTabs(val tabName: String) {
  FOLLOWERS("Followers"),
  FOLLOWINGS("Followings");
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserFollowersScreen(navController: NavController) {
  var selectedTab by remember {
    mutableStateOf(FOLLOWINGS)
  }

  val followersList = remember {
    mutableStateListOf<MyFollowerModel>()
  }
  followersList.addAll(getMyFollowersList())

  Scaffold(
    topBar = {
      CenterAlignedTopAppBar(
        navigationIcon = {
          IconButton(onClick = {
            navController.popBackStack()
          }) {
            Icon(
              imageVector = Icons.Default.ArrowBack,
              contentDescription = "Back"
            )
          }
        },
        title = {
          Text(text = "lil_cutie", color = Color.White)
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
          containerColor = Companion.Black,
          titleContentColor = Color.White,
          navigationIconContentColor = Color.White
        )
      )
    }, modifier = Modifier
      .fillMaxWidth()
      .fillMaxHeight(),
    containerColor = Color.Black
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(it)
    ) {
      Row(
        modifier = Modifier
          .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        BuildTabItem(
          tabTitle = FOLLOWINGS.tabName,
          isSelected = selectedTab == FOLLOWINGS,
          modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .clickable {
              selectedTab = FOLLOWINGS
            }
        )


        BuildTabItem(
          tabTitle = FOLLOWERS.tabName,
          isSelected = selectedTab == FOLLOWERS,
          modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .clickable {
              selectedTab = FOLLOWERS
            }
        )
      }

      LazyColumn {
        itemsIndexed(followersList) { index, model ->
          UserFollowerCard(model, index) { position ->
            followersList[position] =
              followersList[position].copy(following = !followersList[position].following)
          }

        }

      }
    }
  }
}

@Preview
@Composable
fun BuildTabItem(
  tabTitle: String = "Followings",
  isSelected: Boolean = true,
  modifier: Modifier = Modifier.fillMaxWidth()
) {
  val selectedTabStyle = TextStyle(
    fontSize = 18.sp,
    color = Color.White,
    fontWeight = FontWeight.Bold
  )
  val defaultTabStyle = TextStyle(
    fontSize = 18.sp,
    color = Companion.LightGray,
    fontWeight = FontWeight.Normal
  )
  Column(
    modifier = modifier,

    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {
    Text(
      text = tabTitle,
      style = if (isSelected) selectedTabStyle else defaultTabStyle
    )
    Spacer(modifier = Modifier.height(10.dp))

    Divider(
      thickness = if (isSelected) 2.dp else 1.dp,
      color = if (isSelected) ButtonColor else LightGrey,
    )
  }
}