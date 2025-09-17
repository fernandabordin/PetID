package com.example.petid.petlist.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.petid.MainViewModel
import com.example.petid.components.DefaultAlertDialog
import com.example.petid.components.DefaultButton
import com.example.petid.navigation.Routes

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PetListContent(viewModel: MainViewModel, navController: NavController) {
    val petList = viewModel.petList
    val openDialog = remember { mutableStateOf(false) }

    BackHandler {
        navController.popBackStack(Routes.HOME, false)
    }

    LaunchedEffect(Unit) {
        viewModel.hideDeleteButton()
    }

    LazyColumn {
        items(petList) { pet ->
            DefaultAlertDialog(
                title = "Erro",
                text = "Deseja mesmo excluir o pet?",
                onConfirm = { viewModel.deletePet(pet) },
                openDialog = openDialog
            )
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
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "Deletar Pet",
                    onClick = {openDialog.value = true}
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            Divider()
        }
    }
}
