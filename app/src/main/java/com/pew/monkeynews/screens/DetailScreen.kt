package com.pew.monkeynews.screens

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.SubcomposeAsyncImage
import com.pew.monkeynews.components.TopBar
import com.pew.monkeynews.model.Article


@Composable
fun DetailsScreen(news: List<Article>, key: String?) {

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
        TopBar()
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
                AndroidView(
                    factory = { context ->
                        WebView(context).apply {
                            settings.javaScriptEnabled = true
                            webViewClient = WebViewClient()

                            settings.loadWithOverviewMode = true
                            settings.useWideViewPort = true
                            settings.setSupportZoom(true)
                        }
                    },
                    update = { webView ->
                        article?.let { webView.loadUrl(it.url) }
                    }
                )

            }

        }


    }

}
class CustomWebViewClient: WebViewClient(){
    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
        if(url != null && url.startsWith("https://example.com")){
            view?.loadUrl(url)
            return true
        }
        return false
    }
}