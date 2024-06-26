package com.pew.monkeynews

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.pew.monkeynews.components.NewsList
import com.pew.monkeynews.navigation.NewsNavigation
import com.pew.monkeynews.network.NewsApi
import com.pew.monkeynews.repository.NewsRepository
import com.pew.monkeynews.screens.DetailsScreen
import com.pew.monkeynews.screens.HomeScreen
import com.pew.monkeynews.screens.NewsViewModel
import com.pew.monkeynews.ui.theme.MonkeyNewsTheme
import com.pew.monkeynews.ui.theme.fontFamily
import com.pew.monkeynews.ui.theme.fontName
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlin.math.log


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // val newsViewModel = ViewModelProvider(this)[NewsViewModel::class.java]
        val newsViewModel by viewModels<NewsViewModel>()
        setContent {
                     MonkeyNewsTheme {
                         NewsNavigation(newsViewModel)
                     }
            }
        }
    }




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}