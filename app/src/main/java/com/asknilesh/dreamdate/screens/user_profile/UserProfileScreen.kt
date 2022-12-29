@file:OptIn(ExperimentalMaterial3Api::class)

package com.asknilesh.dreamdate.screens.user_profile

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue.Hidden
import androidx.compose.material.icons.Icons.Outlined
import androidx.compose.material.icons.outlined.PersonAddAlt
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.asknilesh.dreamdate.R.drawable
import com.asknilesh.dreamdate.ui.theme.CallButtonColor
import com.asknilesh.dreamdate.ui.theme.LightGrey
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun UserProfileScreen(navController: NavController) {
  val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

  val modalBottomSheetState =
    rememberModalBottomSheetState(initialValue = Hidden)
  val scope = rememberCoroutineScope()
  BackHandler(enabled = modalBottomSheetState.isVisible) {
    scope.launch {
      modalBottomSheetState.hide()
    }
  }
  ModalBottomSheetLayout(
    sheetContent = {
      UserProfileBottomSheetContent()
    },
    sheetState = modalBottomSheetState,
    sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
    sheetBackgroundColor = Color.Black,
    modifier = Modifier
      .fillMaxWidth()
      .fillMaxHeight()
  ) {
    Scaffold(
      modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
      topBar = {
        Column {
          UserProfileActionBar(
            scrollBehavior = scrollBehavior,
            onBackArrowClick = {
              navController.popBackStack()
            },
            onMoreIconClick = {
              scope.launch {
                modalBottomSheetState.show()
              }
            },
          )
          Divider(thickness = 0.5.dp)

        }
      },
      containerColor = Color.Black
    ) { paddingValues ->
      Column(
        modifier = Modifier
          .padding(paddingValues)
          .padding(horizontal = 20.dp)
          .fillMaxWidth()
          .fillMaxHeight()
      ) {
        Spacer(modifier = Modifier.height(20.dp))
        ProfileDetailsSection(navController)
        Spacer(modifier = Modifier.height(15.dp))

        Text(
          text = "Amelia Jones",
          color = Color.White,
          fontWeight = FontWeight.Bold,
          fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "Traveler | Dancer", color = Color.LightGray, fontSize = 16.sp)
        Spacer(modifier = Modifier.height(5.dp))
        Text(
          text = "The three happiest and magical word for an android developer - Gradle build finished",
          color = Color.LightGray,
          fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(10.dp))
        BuildFollowSection()
        Spacer(modifier = Modifier.height(10.dp))

        Button(
          onClick = { /*TODO*/ },
          modifier = Modifier
            .fillMaxWidth(),
          colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
          ),
          shape = RoundedCornerShape(50.dp),
          border = BorderStroke(width = 0.5.dp, color = LightGrey),
        ) {
          Image(
            painter = painterResource(id = drawable.ic_gift),
            contentDescription = "Gift Collection"
          )
          Spacer(modifier = Modifier.width(10.dp))
          Text(text = "Gift Collection")
        }
        Spacer(modifier = Modifier.height(10.dp))

        UserPostList()

      }
    }
  }
}

@Composable
fun BuildFollowSection() {
  Row(
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically,
    modifier = Modifier.fillMaxWidth()
  ) {

    Button(
      onClick = { /*TODO*/ },
      modifier = Modifier
        .fillMaxWidth()
        .weight(1f),
      colors = ButtonDefaults.buttonColors(
        containerColor = CallButtonColor
      ),
      shape = RoundedCornerShape(50.dp),
    ) {
      Icon(imageVector = Outlined.PersonAddAlt, contentDescription = "Follow")
      Spacer(modifier = Modifier.width(10.dp))
      Text(text = "Follow")
    }
    Spacer(modifier = Modifier.width(20.dp))
    Button(
      onClick = { /*TODO*/ },
      modifier = Modifier
        .fillMaxWidth()
        .weight(1f),
      colors = ButtonDefaults.buttonColors(
        containerColor = Color.Transparent
      ),
      shape = RoundedCornerShape(50.dp),
      border = BorderStroke(width = 0.5.dp, color = LightGrey),
    ) {
      Icon(painter = painterResource(id = drawable.ic_chat), contentDescription = "Chat")
      Spacer(modifier = Modifier.width(10.dp))
      Text(text = "Chat")
    }
  }
}