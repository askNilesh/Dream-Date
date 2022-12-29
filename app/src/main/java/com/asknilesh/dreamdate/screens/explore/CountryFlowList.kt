package com.asknilesh.dreamdate.screens.explore

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asknilesh.dreamdate.R
import com.asknilesh.dreamdate.ui.theme.ButtonColor
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment
import com.google.accompanist.flowlayout.SizeMode

@Composable
@Preview
fun CountryFlowList() {

  val selectedItems = remember { mutableStateListOf<String>() }

  Column(modifier = Modifier.fillMaxWidth()) {
    Row(
      horizontalArrangement = Arrangement.SpaceBetween,
      modifier = Modifier.fillMaxWidth()
    ) {
      Text(
        text = "Regions",
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
      mainAxisAlignment = MainAxisAlignment.Start,
      mainAxisSize = SizeMode.Expand,
      crossAxisSpacing = 12.dp,
      mainAxisSpacing = 8.dp
    ) {
      getCountryList().forEach { model ->
        Row(
          modifier = Modifier
            .background(
              color = if (selectedItems.contains(model.countryName)) Color(0xFf4B53FF)
              else Color(0xFF373743),
              shape = RoundedCornerShape(10.dp)
            )
            .clickable {
              if (selectedItems.contains(model.countryName)) {
                selectedItems.remove(model.countryName)
              } else {
                selectedItems.add(model.countryName)
              }
            },
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.Center
        ) {
          Spacer(modifier = Modifier.width(10.dp))
          Image(
            painter = painterResource(id = model.flagIcon),
            contentDescription = "Flag",
            modifier = Modifier.size(15.dp)

          )
          Spacer(modifier = Modifier.width(5.dp))
          Text(
            text = model.countryName,
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

data class CountryModel(
  val countryName: String,
  var isSelected: Boolean = false,
  val flagIcon: Int
)

fun getCountryList() = mutableListOf(
  CountryModel(
    countryName = "India",
    flagIcon = R.drawable.india,
    isSelected = true,
  ),
  CountryModel(
    countryName = "USA",
    flagIcon = R.drawable.usa
  ),
  CountryModel(
    countryName = "Italy",
    flagIcon = R.drawable.italy
  ),
  CountryModel(
    countryName = "Israel",
    flagIcon = R.drawable.israel
  ),
  CountryModel(
    countryName = "Argentina",
    flagIcon = R.drawable.argentina
  ),
  CountryModel(
    countryName = "Japan",
    flagIcon = R.drawable.japan
  ),
  CountryModel(
    countryName = "Mexico",
    flagIcon = R.drawable.mexico
  ),
  CountryModel(
    countryName = "Russia",
    flagIcon = R.drawable.russia
  ),
  CountryModel(
    countryName = "New Zealand",
    flagIcon = R.drawable.new_zealand
  ),
  CountryModel(
    countryName = "Indonesia",
    flagIcon = R.drawable.indonesia
  )

)