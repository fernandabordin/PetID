package com.example.petid.profile.ui

import android.provider.ContactsContract.Profile
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.petid.MainViewModel

@Composable
fun ProfileContent(viewModel: MainViewModel) {

    val pet by viewModel.pet.collectAsState()

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
            color = Color(0xFFF2668B),
            fontSize = 20.sp
        )
        Text(text = pet.age.toString())
        Text(text = pet.color)
        Text(text = pet.gender)
    }
}