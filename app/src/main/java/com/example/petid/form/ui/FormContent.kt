package com.example.petid.form.ui

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.petid.MainViewModel
import com.example.petid.navigation.Routes.FORM
import com.example.petid.navigation.Routes.PROFILE
import coil.compose.AsyncImage
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


@Composable
fun FormContent(navController: NavController? = null, viewModel: MainViewModel) {
    val focusManager = LocalFocusManager.current
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 16.dp)
            .background(color = Color.White)
            .clickable(interactionSource = interactionSource, indication = null) {
                focusManager.clearFocus()
            },
        verticalArrangement = Arrangement.SpaceBetween

    ) {
        val name = remember { mutableStateOf("") }
        val age = remember { mutableStateOf("") }
        val color = remember { mutableStateOf("") }
        val sexo = remember { mutableStateOf("") }
        val cutePink = Color(0xFFF2668B)
        val containerColor = Color(0xFFF2F2F2)

        var selectedImageUri by remember { mutableStateOf<Uri?>(null) }

        val galleryLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent()
        ) { uri: Uri? ->
            selectedImageUri = uri
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = containerColor,
                    unfocusedBorderColor = cutePink,
                    focusedBorderColor = cutePink,
                    focusedLabelColor = cutePink,
                    unfocusedLabelColor = cutePink
                ),
                shape = RoundedCornerShape(18.dp),
                value = name.value,
                label = {
                    Text(text = "Nome")
                },
                onValueChange = { newValue ->
                    name.value = newValue

                }
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = containerColor,
                    unfocusedBorderColor = cutePink,
                    focusedBorderColor = cutePink,
                    focusedLabelColor = cutePink,
                    unfocusedLabelColor = cutePink
                ),
                shape = RoundedCornerShape(18.dp),
                value = age.value,
                label = {
                    Text(text = "Idade")
                },
                onValueChange = { newValue ->
                    age.value = newValue

                }
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = containerColor,
                    unfocusedBorderColor = cutePink,
                    focusedBorderColor = cutePink,
                    focusedLabelColor = cutePink,
                    unfocusedLabelColor = cutePink
                ),
                shape = RoundedCornerShape(18.dp),
                value = color.value,
                label = {
                    Text(text = "Cor")
                },
                onValueChange = { newValue ->
                    color.value = newValue

                }
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = containerColor,
                    unfocusedBorderColor = cutePink,
                    focusedBorderColor = cutePink,
                    focusedLabelColor = cutePink,
                    unfocusedLabelColor = cutePink
                ),
                shape = RoundedCornerShape(18.dp),
                value = sexo.value,
                label = {
                    Text(text = "Sexo")
                },
                onValueChange = { newValue ->
                    sexo.value = newValue

                }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
        
        Button(
            onClick = { galleryLauncher.launch("image/*") },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = cutePink)
        ) {
            Text(text = "Selecionar imagem")
        }
        
        Spacer(modifier = Modifier.height(16.dp))

        selectedImageUri?.let { uri ->
            AsyncImage(
                model = uri,
                contentDescription = "Imagem selecionada",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
        }
        
        Button(
            onClick = {
                viewModel.updatePet(
                    MainViewModel.PetData(
                        name = name.value,
                        age = age.value.toInt(),
                        color = color.value,
                        gender = sexo.value,
                        imageUri = selectedImageUri?.toString()
                    )
                )
                navController?.navigate(PROFILE)
            },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = cutePink),
            content = {
                Text(text = "Confirmar")
            }
        )
    }
}

@Preview
@Composable
fun FormContentPreview() {
//    FormContent()
}