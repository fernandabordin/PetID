package com.example.petid.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.petid.MainViewModel
import com.example.petid.form.ui.FormScreen
import com.example.petid.home.ui.HomeScreen
import com.example.petid.navigation.Routes.FORM
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.petid.navigation.Routes.HOME
import com.example.petid.navigation.Routes.PET_LIST
import com.example.petid.navigation.Routes.PROFILE
import com.example.petid.petlist.ui.PetListScreen
import com.example.petid.profile.ui.ProfileScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun NavHost(
    context: Context
) {
    val navController = rememberNavController()
    val viewModel: MainViewModel = koinViewModel()

    NavHost(navController = navController, startDestination = HOME) {
        composable(route = HOME) {
            HomeScreen(navController = navController)
        }
        composable(route = FORM) {
            FormScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = PROFILE) {
            ProfileScreen(navController = navController, viewModel = viewModel)
        }
        
        composable(route = PET_LIST) {
            PetListScreen(navController = navController, viewModel = viewModel)
        }
    }
}
