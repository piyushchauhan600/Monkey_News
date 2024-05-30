package com.pew.monkeynews

import android.os.Bundle
import android.provider.Settings.Global
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.pew.monkeynews.network.NewsApi
import com.pew.monkeynews.ui.theme.MonkeyNewsTheme
import com.pew.monkeynews.utils.ApiKeyProvider
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.io.encoding.ExperimentalEncodingApi


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var newsApi: NewsApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MonkeyNewsTheme {

            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}