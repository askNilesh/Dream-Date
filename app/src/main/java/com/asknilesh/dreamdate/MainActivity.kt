package com.asknilesh.dreamdate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.view.WindowCompat
import com.asknilesh.dreamdate.navigation.DreamDateNavigation
import com.asknilesh.dreamdate.ui.theme.DreamDateTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
        DreamDateTheme {
          DreamDateNavigation()

      }
    }
  }
}

