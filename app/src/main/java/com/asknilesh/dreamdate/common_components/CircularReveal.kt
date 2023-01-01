package com.asknilesh.dreamdate.common_components

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.platform.debugInspectorInfo
import kotlin.math.sqrt


@SuppressLint("UnnecessaryComposedModifier")
fun Modifier.circularReveal(
  visible: Boolean,
  revealFrom: Offset = Offset(0.5f, 0.5f),
): Modifier = composed(
  factory = {
    val factor = updateTransition(visible, label = "Visibility")
      .animateFloat(label = "revealFactor") { if (it) 1f else 0f }

    circularReveal(factor, revealFrom)
  },
  inspectorInfo = debugInspectorInfo {
    name = "circularReveal"
    properties["visible"] = visible
    properties["revealFrom"] = revealFrom
  }
)


fun Modifier.circularReveal(
  transitionProgress: State<Float>,
  revealFrom: Offset = Offset(0.5f, 0.5f)
): Modifier {
  return drawWithCache {
    val path = Path()

    val center = revealFrom.mapTo(size)
    val radius = calculateRadius(revealFrom, size)

    path.addOval(Rect(center, radius * transitionProgress.value))

    onDrawWithContent {
      clipPath(path) { this@onDrawWithContent.drawContent() }
    }
  }
}

private fun Offset.mapTo(size: Size): Offset {
  return Offset(x * size.width, y * size.height)
}

private fun calculateRadius(normalizedOrigin: Offset, size: Size) = with(normalizedOrigin) {
  val x = (if (x > 0.5f) x else 1 - x) * size.width
  val y = (if (y > 0.5f) y else 1 - y) * size.height

  sqrt(x * x + y * y)
}