package com.example.featuremoviedetail.presentation.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle

@Composable
fun DetailText(label: String, value: String) {
    Text(
        buildAnnotatedString {
            withStyle(style = MaterialTheme.typography.titleMedium.toSpanStyle()) {
                append("$label ")
            }
            withStyle(style = MaterialTheme.typography.bodyLarge.toSpanStyle()) {
                append(value)
            }
        }
    )
}