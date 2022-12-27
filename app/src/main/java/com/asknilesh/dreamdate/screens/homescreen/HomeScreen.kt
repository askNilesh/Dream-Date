package com.asknilesh.dreamdate.screens.homescreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.asknilesh.dreamdate.navigation.NavigationGraph
import com.asknilesh.dreamdate.ui.theme.ButtonColor
import com.asknilesh.dreamdate.ui.theme.LightGrey

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController) {
  val navController2: NavHostController = rememberNavController()

  Scaffold(
    bottomBar = { BottomNavigationView(navController = navController2) }
  ) {
    Box(modifier = Modifier.padding(it)) {
      NavigationGraph(navController = navController2)
    }
  }
}

@Composable
fun BottomNavigationView(navController: NavController) {
  var selectedItem by remember { mutableStateOf(0) }
  val navBackStackEntry by navController.currentBackStackEntryAsState()
  val currentRoute = navBackStackEntry?.destination?.route
  val items = listOf(
    BottomNavItem.Home,
    BottomNavItem.Explore,
    BottomNavItem.Shorts,
    BottomNavItem.Messages,
    BottomNavItem.Profile
  )
  NavigationBar(
    containerColor = Color.Black,
    modifier = Modifier.height(50.dp),

  ) {
    items.forEachIndexed { index, item ->
      NavigationBarItem(
        icon = {
          Icon(painter = painterResource(id = item.icon), contentDescription = item.title)
        },
        selected = currentRoute == item.screenName,
        onClick = {
          selectedItem = index
          navController.navigate(item.screenName) {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            navController.graph.startDestinationRoute?.let { route ->
              popUpTo(route) {
                saveState = true
              }
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
          }
        },
        colors = NavigationBarItemDefaults.colors(
          selectedIconColor = ButtonColor,
          unselectedIconColor = LightGrey,
          indicatorColor = Color.Transparent,
        ),
        alwaysShowLabel = false,
      )
    }
  }
}