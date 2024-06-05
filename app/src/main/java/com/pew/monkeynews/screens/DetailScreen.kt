package com.pew.monkeynews.screens

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import com.pew.monkeynews.model.Article


@SuppressLint("RestrictedApi")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(news: List<Article>, key: String?, navController: NavHostController) {

    var isLoding by remember { mutableStateOf(true) }

    var article: Article? = null
    news.forEach {
        if (it.title == key) {
            article = it
        }
    }
    Column(
        modifier = Modifier
            .padding(0.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
//----------------------------------------------------------------------------------------Top Bar-----------------------------------------------------------------------------------------//
        TopAppBar(
            title = {
                Text(text = buildAnnotatedString {
                    withStyle(
                        SpanStyle(
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Normal

                        )
                    ) {
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
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Notification",
                    modifier = Modifier
                        .size(30.dp)
                        .padding(5.dp)
                        .clickable { navController.popBackStack() },
                    tint = Color.White
                )
            }
        )
//--------------------------------------------------------------------------------------Content-----------------------------------------------------------------------------------------//

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            color = Color(0xff616161),
            shape = RoundedCornerShape(corner = CornerSize(4.dp))
        )
        {
            Column {
                //    Content Text
                MyWebView(url = article?.url.toString())
            }

        }


    }

}


class WebViewActivity : ComponentActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MyWebView(url = "https://www.example.com")
        }
    }
}

@Composable
fun MyWebView(url: String) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        AndroidView(
            factory = { context ->
                WebView(context).apply {
                    webViewClient = WebViewClient()
                    settings.javaScriptEnabled = true // Enable JavaScript if needed
                    loadUrl(url)
                }
            }
        )
    }
}







