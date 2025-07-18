package com.example.petid.petlist.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.petid.MainViewModel
import com.example.petid.components.DefaultButton

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PetListContent(viewModel: MainViewModel) {
    val petList = viewModel.petList

    LazyColumn {
        items(petList) { pet ->
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .combinedClickable(
                        onLongClick = { viewModel.changeValueDeleteButton(pet) },
                        onClick = {}
                    )
            ) {
                pet.imageUri.let { uri ->
                    AsyncImage(
                        model = uri, 
                        contentDescription = "Imagem do Pet",
                        modifier = Modifier
                            .height(200.dp)
                    )
                }
                
                Text(text = "Nome: ${pet.name}")
                Text(text = "Idade: ${pet.age}")
                Text(text = "Cor: ${pet.color}")
                Text(text = "Sexo: ${pet.gender}")
            }

            if(pet.showDeleteButton.value) {
                DefaultButton(
                    text = "Deletar Pet",
                    onClick = {viewModel.deletePet(pet)}
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            Divider()
        }
    }
}