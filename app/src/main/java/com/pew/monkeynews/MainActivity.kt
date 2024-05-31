package com.pew.monkeynews

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pew.monkeynews.network.NewsApi
import com.pew.monkeynews.repository.NewsRepository
import com.pew.monkeynews.screens.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlin.math.log


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // val newsViewModel = ViewModelProvider(this)[NewsViewModel::class.java]
      //           val newsViewModel by viewModels<NewsViewModel>()

        setContent {

            }
        }
    }




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}