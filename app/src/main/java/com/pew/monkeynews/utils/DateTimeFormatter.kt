package com.pew.monkeynews.utils

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Date

@RequiresApi(Build.VERSION_CODES.O)
fun DateTimeFormatter(formattedDateTime: String): String? {
    val instant = Instant.parse(formattedDateTime)
    val localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
    val formatter = DateTimeFormatter.ofPattern("EEE, d MMM hh:mm aaa")
    return localDateTime.format(formatter)
}