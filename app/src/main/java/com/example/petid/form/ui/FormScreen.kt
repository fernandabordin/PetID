package com.example.petid.form.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.petid.home.ui.HomeContent

@Composable
fun FormScreen(navController: NavController) {
    Scaffold(
        content = {
            Box(
                modifier = Modifier.padding(it)
            ) {
                FormContent()
            }
        }
    )
}