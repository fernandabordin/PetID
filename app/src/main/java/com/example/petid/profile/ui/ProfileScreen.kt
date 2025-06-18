package com.example.petid.profile.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.petid.MainViewModel
import com.example.petid.form.ui.FormContent

@Composable
fun ProfileScreen(navController: NavController, viewModel: MainViewModel) {
    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
        ) {
            ProfileContent(viewModel = viewModel, navController = navController)
        }
    }
}