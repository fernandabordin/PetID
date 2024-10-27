package com.example.petid.form.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FormContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(color = Color.White)
    ) {
        val name = remember { mutableStateOf("")}
        val age = remember { mutableStateOf("")}
        val color = remember { mutableStateOf("")}

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color.Magenta
            ),
            value = name.value,
            label = {
                    Text(text = "Nome")
            },
            onValueChange = {newValue ->
                name.value = newValue

            }
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = age.value,
            label = {
                Text(text = "Idade")
            },
            onValueChange = {newValue ->
                age.value = newValue

            }
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = color.value,
            label = {
                Text(text = "Cor")
            },
            onValueChange = {newValue ->
                color.value = newValue

            }
        )

        Button(
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta
            ),
            onClick = {},
            content = {
                Text(text = "Confirmar")
            }
        )
    }
}

@Preview
@Composable
fun FormContentPreview() {
    FormContent()
}