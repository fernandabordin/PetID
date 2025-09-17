package com.example.petid.form.ui

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.petid.MainViewModel
import com.example.petid.components.DefaultButton
import com.example.petid.components.DefaultDropdown
import com.example.petid.components.DefaultTextField
import com.example.petid.navigation.Routes.PROFILE

@Composable
fun FormContent(navController: NavController? = null, viewModel: MainViewModel) {
    val focusManager = LocalFocusManager.current
    val interactionSource = remember { MutableInteractionSource() }
    val selectedSex = remember { mutableStateOf("") }

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
            DefaultTextField(
                text = name,
                label = "Nome",
                onValueChange = { newValue ->
                    name.value = newValue
                }
            )
            DefaultTextField(
                text = age,
                label = "Idade",
                onValueChange = { newValue ->
                    age.value = newValue
                }
            )
            DefaultTextField(
                text = color,
                label = "Cor",
                onValueChange = { newValue ->
                    color.value = newValue
                }
            )
            val genderOptions = listOf("Fêmea", "Macho")
            DefaultDropdown(
                selectedOption = selectedSex.value,
                onOptionSelected = { selectedSex.value = it },
                options = genderOptions,
                label = "Sexo",
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
        DefaultButton(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = { galleryLauncher.launch("image/*") },
            text = "Selecionar imagem"
        )

        Spacer(
            modifier = Modifier
                .height(16.dp)
        )

        selectedImageUri?.let { uri ->
            AsyncImage(
                model = uri,
                contentDescription = "Imagem selecionada",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
        }
        DefaultButton(
            modifier = Modifier
                .fillMaxWidth(),
            enabled = if (name.value.isNotEmpty() && age.value.isNotEmpty() && color.value.isNotEmpty() && selectedSex.value.isNotEmpty() && selectedImageUri != null) {
                true
            } else {
                false
            },
            onClick = {
                viewModel.addPet(
                    MainViewModel.PetData(
                        name = name.value,
                        age = age.value.toInt(),
                        color = color.value,
                        gender = selectedSex.value,
                        imageUri = selectedImageUri?.toString()
                    )
                )
                navController?.navigate(PROFILE)
            },
            text = "Confirmar"
        )
    }
}
