package com.example.uisystem.ui.utils

import java.text.SimpleDateFormat
import java.util.Locale

fun String?.formatToReadableDate(
    inputPattern: String = "yyyy-MM-dd",
    outputPattern: String = "MMMM dd, yyyy",
    locale: Locale = Locale.ENGLISH
): String {
    if (this.isNullOrEmpty()) return "Unknown date"

    return try {
        val inputFormat = SimpleDateFormat(inputPattern, locale)
        val outputFormat = SimpleDateFormat(outputPattern, locale)
        val parsedDate = inputFormat.parse(this)
        parsedDate?.let { outputFormat.format(it) } ?: "Unknown date"
    } catch (e: Exception) {
        "Invalid date: ${e.message}"
    }
}