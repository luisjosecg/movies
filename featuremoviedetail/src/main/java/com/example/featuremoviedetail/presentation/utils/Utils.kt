package com.example.featuremoviedetail.presentation.utils

import java.text.SimpleDateFormat
import java.util.Locale

object Utils {

    fun formatDate(date: String?): String {
        return try {
            val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val outputFormat = SimpleDateFormat("MMMM dd, yyyy",  Locale.ENGLISH)
            val parsedDate = inputFormat.parse(date ?: "")
            parsedDate?.let { outputFormat.format(it) } ?: "Unknown date"
        } catch (e: Exception) {
            "Invalid date: ${e.message}"
        }
    }
}