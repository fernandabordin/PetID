package com.example.petid.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.petid.home.ui.HomeScreen
import com.example.petid.navigation.Routes.HOME

@Composable
fun NavHost(
    context: Context
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = HOME) {
        composable(route = HOME) {
            HomeScreen(navController = navController)
        }
    }
}
