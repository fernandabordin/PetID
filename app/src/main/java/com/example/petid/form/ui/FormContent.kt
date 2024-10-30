package com.example.petid.form.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FormContent() {
    val focusManager = LocalFocusManager.current
    val interactionSource = remember { MutableInteractionSource() }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(color = Color.White)
            .clickable(interactionSource = interactionSource, indication = null) {
                focusManager.clearFocus()
            }
    ) {

        val name = remember { mutableStateOf("")}
        val age = remember { mutableStateOf("")}
        val color = remember { mutableStateOf("")}
        val cutePink = Color(0xFFF2668B)
        val containerColor = Color(0xFFF2F2F2)

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
            onValueChange = {newValue ->
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
            onValueChange = {newValue ->
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
            onValueChange = {newValue ->
                color.value = newValue

            }
        )

        Button(
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = cutePink
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