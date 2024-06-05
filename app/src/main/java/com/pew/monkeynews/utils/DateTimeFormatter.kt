package com.pew.monkeynews.utils

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

fun dateTimeFormatter(formattedDateTime: String): String? {
    return try {
        val instant = Instant.parse(formattedDateTime)
        val localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
        val formatter = DateTimeFormatter.ofPattern("EEE, d MMM")
        localDateTime.format(formatter)
    } catch (e: DateTimeParseException) {
        // Handle the exception, e.g., log the error or return a default value
        android.util.Log.e("@@@@@", "Error parsing date: ${e.message}")
        null // Or return a default string like "Invalid Date"
    }
}