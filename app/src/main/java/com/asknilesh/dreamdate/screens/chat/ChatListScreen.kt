package com.asknilesh.dreamdate.screens.chat

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.asknilesh.dreamdate.model.getChatList
import com.asknilesh.dreamdate.navigation.DreamDateScreens
import com.asknilesh.dreamdate.ui.theme.LightGrey

@Composable
fun ChatListScreen(navController: NavController) {
  var searchQueryState by remember {
    mutableStateOf("")
  }
  val models = getChatList()
  val chatList = remember(searchQueryState) {
    if (searchQueryState.isEmpty()) models
    else models.filter { it.userName.contains(searchQueryState, ignoreCase = true) }
  }
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .fillMaxHeight()
      .background(Color.Black)
      .padding(horizontal = 15.dp)
  ) {
    Spacer(modifier = Modifier.height(10.dp))
    Row(
      modifier = Modifier.fillMaxWidth(),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.Start
    ) {
      Text(
        text = "Chat",
        fontSize = 24.sp,
        color = Color.White,
        fontWeight = FontWeight.Bold
      )
      Spacer(modifier = Modifier.width(20.dp))
      Icon(
        imageVector = Icons.Default.Lock,
        contentDescription = "",
        tint = Color.LightGray,
        modifier = Modifier.size(12.dp)
      )
      Spacer(modifier = Modifier.width(5.dp))
      Text(
        text = "End-to-End Encrypted",
        fontSize = 10.sp,
        color = Color.LightGray,
        fontWeight = FontWeight.Normal
      )
    }
    Spacer(modifier = Modifier.height(10.dp))
    BuildSearchTextField { query ->
      searchQueryState = query
    }
    Spacer(modifier = Modifier.height(20.dp))

    LazyColumn {
      items(chatList) {
        ChatCardItem(it) {
          navController.navigate(DreamDateScreens.CHAT_SCREEN.name)
        }
      }
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun BuildSearchTextField(
  modifier: Modifier = Modifier.fillMaxWidth(),
  onSearch: (String) -> Unit = {}
) {
  val keyboardController = LocalSoftwareKeyboardController.current

  var searchState by remember {
    mutableStateOf("")
  }
  TextField(value = searchState,
    placeholder = { androidx.compose.material3.Text(text = "Search friends..") },
    onValueChange = {
      searchState = it
      onSearch(searchState)
    },
    maxLines = 1,
    keyboardOptions = KeyboardOptions(
      keyboardType = KeyboardType.Text, imeAction = ImeAction.Search
    ),
    keyboardActions = KeyboardActions {
      if (searchState.isEmpty()) return@KeyboardActions
      onSearch(searchState)
      keyboardController?.hide()
    },
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
    trailingIcon = {
      if (searchState.isNotEmpty()) {
        IconButton(onClick = {
          searchState = ""
          onSearch("")
        }) {
          Icon(
            imageVector = Icons.Default.Close,
            contentDescription = "Close",
            tint = Color.White
          )
        }
      }
    }

  )
}