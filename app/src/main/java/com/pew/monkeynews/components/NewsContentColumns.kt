package com.pew.monkeynews.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.pew.monkeynews.R
import com.pew.monkeynews.model.Article
import com.pew.monkeynews.utils.dateTimeFormatter
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
//@Preview(showBackground = true)
@Composable
fun NewsList(
    article: Article,
    Onclick: (String) -> Unit
) {

    var date by remember { mutableStateOf("") }
    date = dateTimeFormatter(article.publishedAt).toString()

//----------------------------------------------------------------States Of UI---------------------------------------------------------=//
    var isVisible by remember { mutableStateOf(false) }
//--------------------------------------------------------------UI---------------------------------------------------------------------//
    Column(
        modifier = Modifier
            .clickable { Onclick(article.title) }
    ) {
// -----------------------------------------------------------List Image ----------------------------------------------------- // Working Later

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(article.urlToImage)
                .fallback(R.drawable._7d457640_62eb_4140_927e_f26aedb3935f)
                .build(),
            placeholder = painterResource(id = R.drawable._a3a47a57_74a8_4f09_b5b8_835723c11ca6_min),
            contentDescription = "Image",
            contentScale = ContentScale.Fit,
            modifier = Modifier.fillMaxWidth()
        )
//--------------------------------------------------------------content--------------------------------------------------------------------//

        Column(
            modifier = Modifier
                .padding(6.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            //Title
            Text(
                text = article.title,
                modifier = Modifier.padding(2.dp),
                fontSize = 16.sp,
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Normal,
                color = Color.Black,

                lineHeight = 20.sp
            )
            Row(
                modifier = Modifier
                    .padding()
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                //Published At
                    Text(
                        text = date,
                        modifier = Modifier.padding(4.dp),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    )

                Icon(imageVector = if (isVisible) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = stringResource(R.string.keyboard_arrow_down),
                    modifier = Modifier
                        .padding(4.dp)
                        .clickable { isVisible = !isVisible }
                )
            }
            AnimatedVisibility(
                visible = isVisible,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                Column(Modifier.padding(4.dp)) {
                    Text(
                        text = article.description?: "No description",
                        modifier = Modifier.padding(2.dp),
                        fontSize = 16.sp,
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black,
                        lineHeight = 20.sp
                    )

                }
            }

        }
    }
}