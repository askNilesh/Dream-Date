package com.asknilesh.dreamdate.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asknilesh.dreamdate.R
import com.asknilesh.dreamdate.ui.theme.LightGrey

@Composable
fun ProfileBottomSheetContent(
  onListItemClick: () -> Unit = {}
) {
  val context = LocalContext.current


  Column(
    modifier = Modifier
      .fillMaxWidth()
      .wrapContentHeight()
      .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
      .background(Color(0xff1A1A27))
      .padding(horizontal = 10.dp)
  ) {
    Spacer(modifier = Modifier.height(20.dp))
    SheetListItem(
      icon = R.drawable.ic_edit,
      title = "Edit Profile",
      onItemClick = { title ->
        onListItemClick.invoke()
      })

    SheetListItem(
      icon = R.drawable.ic_star,
      title = "My Level",
      onItemClick = { title ->
        onListItemClick.invoke()
      })

    SheetListItem(
      icon = R.drawable.ic_plus,
      title = "My Coin Balance",
      onItemClick = { title ->
        onListItemClick.invoke()
      })

    SheetListItem(
      icon = R.drawable.ic_money,
      title = "My Earnings",
      onItemClick = { title ->
        onListItemClick.invoke()
      })


    SheetListItem(
      icon = R.drawable.ic_save,
      title = "Saved Shorts",
      onItemClick = { title ->
        onListItemClick.invoke()
      })


    SheetListItem(
      icon = R.drawable.ic_setting,
      title = "Settings",
      onItemClick = { title ->
        onListItemClick.invoke()
      })
  }
}

@Composable
@Preview
fun SheetListItem(
  icon: Int = R.drawable.ic_report,
  title: String = " jdhjhfd",
  textColor: Color = Color.White,
  onItemClick: (String) -> Unit = {
  }
) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .clickable(onClick = { onItemClick(title) })
      .height(55.dp)
      .padding(start = 10.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.Center
  ) {
    Image(
      painter = painterResource(id = icon), contentDescription = title,
      modifier = Modifier.size(24.dp)
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
        text = title,
        color = textColor,
        modifier = Modifier
          .fillMaxWidth()
      )
      Spacer(modifier = Modifier.height(10.dp))
      Divider(
        thickness = 0.5.dp,
        color = LightGrey
      )

    }
    Icon(imageVector = Icons.Default.ArrowRight, contentDescription = "", tint = LightGrey)
    Spacer(modifier = Modifier.width(10.dp))
  }
}