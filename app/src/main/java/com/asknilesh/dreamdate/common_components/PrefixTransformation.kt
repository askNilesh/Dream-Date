package com.asknilesh.dreamdate.common_components

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class PrefixTransformation(val prefix: String) : VisualTransformation {
  override fun filter(text: AnnotatedString): TransformedText {
    return PrefixFilter(text, prefix)
  }
}

fun PrefixFilter(number: AnnotatedString, prefix: String): TransformedText {

  val out = prefix + number.text
  val prefixOffset = prefix.length

  val numberOffsetTranslator = object : OffsetMapping {
    override fun originalToTransformed(offset: Int): Int {
      return offset + prefixOffset
    }

    override fun transformedToOriginal(offset: Int): Int {
      if (offset < prefixOffset) return 0
      return offset - prefixOffset
    }
  }

  return TransformedText(AnnotatedString(out), numberOffsetTranslator)
}