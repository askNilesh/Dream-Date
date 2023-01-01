package com.asknilesh.dreamdate.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.Block
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Policy
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.asknilesh.dreamdate.ui.theme.ButtonColor
import com.asknilesh.dreamdate.ui.theme.LightGrey

data class SettingModel(
  val name: String,
  val icon: ImageVector,
  val iconTint: Color = LightGrey,
  val textColor: Color = Color.White
)

fun getSettingList() = mutableListOf(
  SettingModel(
    name = "My Payment Methods",
    icon = Icons.Default.AccountBalance
  ),
  SettingModel(
    name = "Change Password",
    icon = Icons.Default.Password
  ),
  SettingModel(
    name = "App Language",
    icon = Icons.Default.Language
  ),
  SettingModel(
    name = "Help",
    icon = Icons.Default.Help
  ),
  SettingModel(
    name = "Block List",
    icon = Icons.Default.Block
  ),
  SettingModel(
    name = "Privacy Policy",
    icon = Icons.Default.Policy
  ),
  SettingModel(
    name = "About Us",
    icon = Icons.Default.Groups
  ),
  SettingModel(
    name = "Rate Us",
    icon = Icons.Default.Star
  ),
  SettingModel(
    name = "Delete My Account",
    icon = Icons.Default.Delete,
    iconTint = ButtonColor,
    textColor = ButtonColor,

    ),

  SettingModel(
    name = "Delete My Account",
    icon = Icons.Default.Logout,
    iconTint = ButtonColor,
    textColor = ButtonColor
  ),

  )