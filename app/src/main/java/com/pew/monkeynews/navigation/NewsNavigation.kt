package com.pew.monkeynews.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pew.monkeynews.screens.DetailsScreen
import com.pew.monkeynews.screens.HomeScreen
import com.pew.monkeynews.screens.NewsViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NewsNavigation(newsViewModel: NewsViewModel) {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "HomeScreen") {
        composable(route = "HomeScreen") {
            HomeScreen(newsViewModel,navController)
        }
        composable(route = "DetailsScreen/{key}", arguments = listOf(
            navArgument("key") {
                type = NavType.StringType
            }
        ))
        {
            val key = it.arguments?.getString("key")
            newsViewModel.data.value.data?.articles?.let { it1 -> DetailsScreen(it1,key,navController) }
        }
    }
}