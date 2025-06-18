package com.example.petid.profile.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.petid.MainViewModel
import com.example.petid.navigation.Routes

@Composable
fun ProfileContent(viewModel: MainViewModel, navController: NavController) {
    val pet by viewModel.pet.collectAsState()
    val cutiePink = Color(0xFFF2668B)

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 16.dp)
            .background(color = Color.White)
    ) {
        pet.imageUri?.let { uriString ->
            AsyncImage(
                model = uriString,
                contentDescription = "Imagem do Pet",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )
        }

        Text(
            text = pet.name,
            color = cutiePink,
            fontSize = 20.sp
        )
        Text(
            text = pet.age.toString(),
            color = cutiePink
        )
        Text(
            text = pet.color,
            color = cutiePink
        )
        Text(
            text = pet.gender,
            color = cutiePink
        )
        
        Button(
            onClick = {
                navController.navigate(Routes.PET_LIST)
            },
            colors = ButtonDefaults.buttonColors(containerColor = cutiePink)
        ) {
            Text(text = "Lista de Pets")
        }
    }
}