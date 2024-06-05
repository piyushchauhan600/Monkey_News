package com.pew.monkeynews.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pew.monkeynews.R
import com.pew.monkeynews.ui.theme.Typography
import com.pew.monkeynews.ui.theme.fontFamily


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Text(text = buildAnnotatedString {
                withStyle(SpanStyle(
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal

                )) {
                    append("Monkey News")
                }
            })
        },
        modifier = Modifier
            .padding(0.dp)
            .height(75.dp)
            .clip(shape = RectangleShape),
        colors = TopAppBarDefaults.topAppBarColors(Color(0xff864AF9)),
        actions = {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Notification",
                modifier = Modifier
                    .size(30.dp)
                    .padding(5.dp)
                    .clickable { },
                tint = Color.White
            )
        }
    )
}
