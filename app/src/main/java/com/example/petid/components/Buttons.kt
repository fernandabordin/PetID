package com.example.petid.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun DefaultButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    color: Color = Color(0xFFF2668B)
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        content = {
            Text(text = text)
        },
        colors = ButtonDefaults.buttonColors(containerColor = color)
    )
}
