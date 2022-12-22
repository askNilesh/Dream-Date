package com.asknilesh.dreamdate.screens.login

import android.util.Log
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

//By signing up, you agree to the Terms & conditions and Privacy policy.
@Composable
@Preview
fun BuildTermAndPrivacy(
  modifier: Modifier = Modifier,
  onPolicyCLick: (url : String) -> Unit = {},
  onTermsClick: (url : String) -> Unit = {}
) {
  val normalStyle = SpanStyle(
    color = Color.LightGray,
    fontSize = 12.sp,
  )
  val customStyle = SpanStyle(
    color = Color.White, fontWeight = FontWeight.Bold,
    fontSize = 12.sp
  )
  val annotatedString = buildAnnotatedString {
    withStyle(
      style = normalStyle
    ) {
      append("By signing up, you agree to the")
      append(" ")
    }
    pushStringAnnotation(tag = "TERMS", annotation = "https://github.com/askNilesh")
    withStyle(
      style = customStyle
    ) {
      append("Terms & conditions")
      append(" ")
    }
    withStyle(
      style = normalStyle
    ) {
      append("and")
      append(" ")
    }
    pushStringAnnotation(
      tag = "POLICY",
      annotation = "https://stackoverflow.com/users/7666442/asknilesh?tab=profile"
    )
    withStyle(
      style = customStyle
    ) {
      append("Privacy policy")
    }
  }
  ClickableText(
    text = annotatedString,
    modifier = modifier,
    onClick = { offset ->
      annotatedString.getStringAnnotations(tag = "TERMS", start = offset, end = offset)
        .firstOrNull()?.let {
          Log.d("TERMS URL", it.item)
          onTermsClick(it.item)
        }

      annotatedString.getStringAnnotations(tag = "POLICY", start = offset, end = offset)
        .firstOrNull()?.let {
          Log.d("POLICY URL", it.item)
          onPolicyCLick(it.item)
        }
    }
  )
}