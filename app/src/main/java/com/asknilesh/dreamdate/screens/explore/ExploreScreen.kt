@file:OptIn(ExperimentalMaterialApi::class)

package com.asknilesh.dreamdate.screens.explore

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.asknilesh.dreamdate.model.getExplorePageList
import com.asknilesh.dreamdate.navigation.DreamDateScreens
import com.asknilesh.dreamdate.ui.theme.LightGrey
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter") @Composable
fun ExploreScreen(navController: NavController) {

  val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
  val state = rememberLazyStaggeredGridState()
  val modalBottomSheetState =
    rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
  val scope = rememberCoroutineScope()
  BackHandler(enabled = modalBottomSheetState.isVisible){
    scope.launch{
      modalBottomSheetState.hide()
    }
  }
  ModalBottomSheetLayout(
    sheetContent = {
      ExploreFilterBottomSheet()
    },
    sheetState = modalBottomSheetState,
    sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
    sheetBackgroundColor = Color.Black,
    modifier = Modifier
      .fillMaxWidth()
      .fillMaxHeight()
  ) {
    Scaffold(
      modifier = Modifier
        .nestedScroll(scrollBehavior.nestedScrollConnection)
        .fillMaxWidth()
        .fillMaxHeight(),
      topBar = {
        ExploreScreenActionBar(scrollBehavior = scrollBehavior) {
          scope.launch {
            modalBottomSheetState.show()
          }
        }
      },
      backgroundColor = Color.Black,
    ) { paddingValues ->
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .fillMaxHeight()
          .padding(paddingValues)
          .padding(horizontal = 10.dp)
      ) {
        Spacer(modifier = Modifier.height(10.dp))
        BuildSearchTextField()
        Spacer(modifier = Modifier.height(10.dp))
        LazyVerticalStaggeredGrid(
          columns = StaggeredGridCells.Fixed(2),
          state = state,
        ) {
          items(getExplorePageList()) { model ->
            BuildExploreCard(model) {
              navController.navigate(DreamDateScreens.USER_PROFILE_SCREEN.name)
            }
          }
        }
      }
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class) @Composable @Preview
fun BuildSearchTextField(modifier: Modifier = Modifier.fillMaxWidth()) {
  var searchState by remember {
    mutableStateOf("")
  }
  TextField(value = searchState,
    placeholder = { Text(text = "Search friends..") },
    onValueChange = {
      searchState = it
    },
    maxLines = 1,
    keyboardOptions = KeyboardOptions(
      keyboardType = KeyboardType.Text, imeAction = ImeAction.Done
    ),
    shape = RoundedCornerShape(30.dp),
    colors = TextFieldDefaults.textFieldColors(
      focusedIndicatorColor = Color.Transparent,
      unfocusedIndicatorColor = Color.Transparent,
      cursorColor = Color.White,
      containerColor = LightGrey.copy(alpha = .2f),
      textColor = Color.White,
      placeholderColor = Color.White
    ),
    modifier = modifier.border(
      border = BorderStroke(width = 1.dp, color = LightGrey), shape = RoundedCornerShape(30.dp)
    ),
    readOnly = true,
    leadingIcon = {
      Icon(imageVector = Icons.Default.Search, contentDescription = "Search", tint = Color.White)
    }

  )
}