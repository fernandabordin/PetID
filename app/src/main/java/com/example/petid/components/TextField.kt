package com.example.petid.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DefaultTextField(
    modifier: Modifier = Modifier,
    label: String,
    text: MutableState<String>,
    onValueChange: (String) -> Unit,
    containerColor: Color =Color(0xFFF2F2F2),
    borderColor: Color = Color(0xFFF2668B),
    shape: RoundedCornerShape = RoundedCornerShape(18.dp)
) {
    OutlinedTextField(
        value = text.value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        modifier = modifier.fillMaxWidth(),
        shape = shape,
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = containerColor,
            focusedBorderColor = borderColor,
            unfocusedBorderColor = borderColor,
            focusedLabelColor = borderColor,
            unfocusedLabelColor = borderColor
        )
    )
}
