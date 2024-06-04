package com.pew.monkeynews.screens

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pew.monkeynews.components.NewsList
import com.pew.monkeynews.components.TopBar


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(viewModel: NewsViewModel? = null,
               navController: NavController) {

    //Checking Is Content Null Or Not
    if (viewModel?.data?.value?.isloding!!) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator()
        }
    } else {

        //-----------------------------------------------------Mutable State----------------------------------------------//
        val newslist = viewModel?.data?.value?.data?.articles?.toMutableStateList()



        Column(
            modifier = Modifier
                .padding(0.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
        ) {
            //------------------------------------------------- Top Bar -----------------------------------------------------------//
            TopBar()

            //---------------------------------------------News Display----------------------------------------------------------//
            Column(
                modifier = Modifier
                    .padding(0.dp)
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                LazyColumn {
                    if (newslist != null) {
                        items(items = newslist) {
                            NewsList(it){
                                navController.navigate("DetailsScreen/${it}")
                            }
                        }
                    }
                }

            }

        }

    }


}
