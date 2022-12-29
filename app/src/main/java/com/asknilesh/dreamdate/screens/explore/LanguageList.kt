package com.asknilesh.dreamdate.screens.explore

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asknilesh.dreamdate.ui.theme.ButtonColor
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment.Start
import com.google.accompanist.flowlayout.SizeMode.Expand

@Composable
fun LanguageList() {
  val languageList = listOf(
    "Hindi", "English", "Spanish", "Bengali", "Tamil", "French", "Arabic",
    "German",
    "Portuguese",
    "Italian",
    "Tamil",
    "Japanese",
    "Korean",
    "Marathi",
    "Vietnamese",
  )
  val selectedItems = remember { mutableStateListOf<String>() }
  Column(modifier = Modifier.fillMaxWidth()) {
    Row(
      horizontalArrangement = Arrangement.SpaceBetween,
      modifier = Modifier.fillMaxWidth()
    ) {
      Text(
        text = "Languages",
        color = Color.White,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
      )

      Text(
        text = "Clear",
        color = ButtonColor,
        fontSize = 20.sp,
        modifier = Modifier.clickable {
          selectedItems.clear()
        }
      )
    }
    Spacer(modifier = Modifier.height(20.dp))
    FlowRow(
      modifier = Modifier.padding(0.dp),
      mainAxisAlignment = Start,
      mainAxisSize = Expand,
      crossAxisSpacing = 12.dp,
      mainAxisSpacing = 8.dp
    ) {
      languageList.forEach {  language ->
        Row(
          modifier = Modifier
            .background(
              color = if (selectedItems.contains(language)) Color(0xFf4B53FF)
              else Color(0xFF373743),
              shape = RoundedCornerShape(10.dp)
            )
            .clickable {
              if (selectedItems.contains(language)) {
                selectedItems.remove(language)
              } else {
                selectedItems.add(language)
              }
            },
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.Center
        ) {
          Text(
            text = language,
            color = Color.White,
            modifier = Modifier
              .padding(horizontal = 10.dp, vertical = 5.dp)
              .clip(
                RoundedCornerShape(10.dp)
              )
          )
        }
      }
    }
  }

}