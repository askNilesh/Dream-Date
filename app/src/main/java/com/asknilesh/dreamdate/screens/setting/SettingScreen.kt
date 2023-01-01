package com.asknilesh.dreamdate.screens.setting

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.asknilesh.dreamdate.model.SettingModel
import com.asknilesh.dreamdate.model.getSettingList
import com.asknilesh.dreamdate.ui.theme.LightGrey

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun SettingScreen(navController: NavController = NavController(LocalContext.current)) {
  val settingList = getSettingList()
  Scaffold(
    topBar = {
      Column {
        CenterAlignedTopAppBar(
          title = { Text(text = "Setting", color = Color.White) },

          navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
              Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
            }
          },
          colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Black,
            navigationIconContentColor = Color.White,
          ),
        )
        Divider(thickness = 0.5.dp)
      }
    },
    containerColor = Color.Black

  ) { paddingValues ->
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(paddingValues)
        .padding(horizontal = 10.dp)
    ) {
      Spacer(modifier = Modifier.height(20.dp))
      LazyColumn {
        items(settingList) { model ->
          buildSettingItem(model)
        }
      }

    }
  }
}

@Composable
@Preview
fun buildSettingItem(
  model: SettingModel = SettingModel(
    name = "My Payment Methods",
    icon = Icons.Default.AccountBalance
  )
) {

  Column(
    modifier = Modifier
      .padding(5.dp)
      .clickable(onClick = { })
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 5.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.Center
    ) {
      Icon(
        imageVector = model.icon,
        contentDescription = model.name,
        modifier = Modifier.size(24.dp),
        tint = model.iconTint
      )
      Spacer(modifier = Modifier.width(10.dp))
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .weight(1f),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Text(
          text = model.name,
          color = model.textColor,
          modifier = Modifier
            .fillMaxWidth()
        )

      }
      Icon(
        imageVector = Icons.Default.ArrowForwardIos,
        contentDescription = "",
        tint = LightGrey
      )
      Spacer(modifier = Modifier.width(10.dp))
    }
    Spacer(modifier = Modifier.height(5.dp))

    Divider(
      thickness = 0.5.dp,
      color = LightGrey
    )
    Spacer(modifier = Modifier.height(5.dp))

  }
}