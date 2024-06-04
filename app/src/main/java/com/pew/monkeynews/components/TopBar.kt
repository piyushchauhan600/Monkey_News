package com.pew.monkeynews.components

import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pew.monkeynews.R
import com.pew.monkeynews.ui.theme.fontFamily


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.monkey_news),
                color = Color.White,
                fontFamily = fontFamily,
                fontSize = 20.sp, // Specify font size
                modifier = Modifier.padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                )
            )
        },
        modifier = Modifier.padding(0.dp),
        colors = TopAppBarDefaults.topAppBarColors(Color.DarkGray),
        actions = {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Notification",
                modifier = Modifier
                    .size(30.dp)
                    .padding(5.dp),
                tint = Color.White
            )
        }
    )
}
