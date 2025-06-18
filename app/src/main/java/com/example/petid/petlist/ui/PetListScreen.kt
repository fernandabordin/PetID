package com.example.petid.petlist.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.petid.MainViewModel

@Composable
fun PetListScreen(navController: NavController, viewModel: MainViewModel) {
    Scaffold(
        content = { paddingValues ->
            Box(modifier = Modifier
                .padding(paddingValues))
            PetListContent(viewModel = viewModel)
        }
    )
}
