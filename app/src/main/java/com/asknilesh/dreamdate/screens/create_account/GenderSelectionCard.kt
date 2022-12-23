package com.asknilesh.dreamdate.screens.create_account

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asknilesh.dreamdate.R
import com.asknilesh.dreamdate.R.drawable
import com.asknilesh.dreamdate.ui.theme.ButtonColor
import com.asknilesh.dreamdate.ui.theme.LightGrey

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun GenderSelectionCard(
  modifier: Modifier = Modifier.fillMaxWidth(),
  painter: Painter = painterResource(id = R.drawable.ic_male),
  genderState: MutableState<Boolean> = mutableStateOf(false),
  selectedStateColor: Color = ButtonColor,
  defaultStateColor: Color = LightGrey,
  genderText: String = "Male",
  onGenderSelected: () -> Unit = {}
) {

  Card(
    modifier = modifier.padding(10.dp),
    onClick = {
      onGenderSelected()
    },
    shape = RoundedCornerShape(30.dp),
    border = BorderStroke(
      width = 0.5.dp,
      color = if (genderState.value) selectedStateColor else defaultStateColor,
    ),
    enabled = true,
    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
    colors = CardDefaults.cardColors(containerColor = Color.Transparent),
  ) {
    Row(
      modifier = modifier
        .padding(horizontal = 10.dp, vertical = 15.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.Center
    ) {
      Image(
        painter = painter,
        contentDescription = genderText,
        modifier = Modifier.size(35.dp)
      )
      Spacer(modifier = Modifier.width(10.dp))
      Text(
        text = genderText, modifier = Modifier
          .fillMaxWidth()
          .weight(1f)
      )
      Spacer(modifier = Modifier.width(10.dp))
      if (genderState.value) {
        Image(painter = painterResource(id = drawable.ic_check), contentDescription = genderText)
      }

    }
  }
}