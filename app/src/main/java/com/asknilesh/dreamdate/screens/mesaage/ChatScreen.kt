package com.asknilesh.dreamdate.screens.mesaage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Attachment
import androidx.compose.material.icons.outlined.Duo
import androidx.compose.material.icons.outlined.Mic
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImagePainter.State.Error
import coil.compose.AsyncImagePainter.State.Loading
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.asknilesh.dreamdate.model.getMessageList
import com.asknilesh.dreamdate.screens.user_profile.userImage
import com.asknilesh.dreamdate.ui.theme.ButtonColor
import com.asknilesh.dreamdate.ui.theme.CallButtonColor
import com.asknilesh.dreamdate.ui.theme.LightGrey

@Preview @Composable
fun ChatScreen(navController: NavController = NavController(LocalContext.current)) {
  val chatList = getMessageList()
  val hideButtons = remember { mutableStateOf(false) }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .fillMaxHeight()
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      IconButton(onClick = { navController.popBackStack() }) {
        Icon(
          imageVector = Icons.Default.ArrowBack, contentDescription = "Back",
          tint = Color.White
        )
      }
      SubcomposeAsyncImage(
        model = userImage,
        contentDescription = null,
        modifier = Modifier
          .width(40.dp)
          .height(40.dp)
          .clip(CircleShape),
        contentScale = ContentScale.Crop,
      ) {
        val state = painter.state
        if (state is Loading || state is Error) {
          CircularProgressIndicator(
            color = ButtonColor, modifier = Modifier.height(60.dp)
          )
        } else {
          SubcomposeAsyncImageContent()
        }
      }
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 10.dp)
          .weight(1f)
      ) {
        Text(
          text = "Elia Armstrong",
          color = Color.White,
          fontSize = 18.sp,
          fontWeight = FontWeight.Bold
        )
        Text(
          text = "Online",
          color = Color.Green,
          fontSize = 14.sp,
        )
      }

      IconButton(onClick = { /*TODO*/ }) {
        Icon(
          imageVector = Icons.Default.MoreVert,
          contentDescription = "",
          tint = Color.White
        )
      }
    }
    Divider()
    Spacer(modifier = Modifier.height(20.dp))
    LazyColumn(
      reverseLayout = true, modifier = Modifier
        .fillMaxHeight()
        .weight(1f)
    ) {
      items(chatList) { model ->
        MessageCard(model)
      }
    }


    Row(
      modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()
        .background(
          shape = RoundedCornerShape(10.dp),
          color = LightGrey.copy(alpha = 0.5f),
        )
        .padding(2.dp),
      horizontalArrangement = Arrangement.Center,
      verticalAlignment = Alignment.CenterVertically
    ) {

      IconButton(
        onClick = { /*TODO*/ },
        colors = IconButtonDefaults.iconButtonColors(
          containerColor = CallButtonColor
        )
      ) {
        Icon(
          imageVector = Icons.Outlined.Duo, contentDescription = "Attachment",
          tint = Color.White
        )
      }

      BuildTextField(
        modifier = Modifier
          .fillMaxWidth()
          .weight(1f),
        hideButtons = hideButtons
      )

      if (!hideButtons.value) {
        IconButton(onClick = { /*TODO*/ }) {
          Icon(
            imageVector = Icons.Outlined.Attachment, contentDescription = "Attachment",
            tint = Color.White
          )
        }
        IconButton(onClick = { /*TODO*/ }) {
          Icon(
            imageVector = Icons.Outlined.Mic, contentDescription = "Attachment",
            tint = Color.White
          )
        }
      }

    }
  }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
@Preview
fun BuildTextField(
  modifier: Modifier = Modifier.fillMaxWidth(),
  hideButtons: MutableState<Boolean> = mutableStateOf(true)
) {
  var messageState by remember {
    mutableStateOf("")
  }
  val keyBoardController = LocalSoftwareKeyboardController.current
  TextField(
    value = messageState,
    placeholder = { Text(text = "Type...") },
    onValueChange = {
      messageState = it
      hideButtons.value = messageState.isNotEmpty()
    },
    maxLines = 3,
    keyboardOptions = KeyboardOptions(
      keyboardType = KeyboardType.Text,
      imeAction = ImeAction.Send
    ),
    shape = RoundedCornerShape(30.dp),
    colors = TextFieldDefaults.textFieldColors(
      focusedIndicatorColor = Color.Transparent,
      unfocusedIndicatorColor = Color.Transparent,
      cursorColor = Color.White,
      containerColor = Color.Transparent,
      textColor = Color.White,
      placeholderColor = Color.White
    ),
    modifier = modifier,
    readOnly = false,
    keyboardActions = KeyboardActions {
      if (messageState.isEmpty()) return@KeyboardActions
      keyBoardController?.hide()
      messageState = ""
      hideButtons.value = messageState.isNotEmpty()
    },
    trailingIcon = {
      if (messageState.isNotEmpty()) {
        Text(
          text = "Send", color = Color.White, fontWeight = FontWeight.Bold,
          fontSize = 16.sp
        )
      }
    }
  )
}