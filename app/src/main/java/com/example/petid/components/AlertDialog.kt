package com.example.petid.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultAlertDialog(
    modifier: Modifier = Modifier,
    title: String,
    text: String,
    onConfirm: () -> Unit,
    onDismiss: (() -> Unit)? = null,
    openDialog: MutableState<Boolean>,
    color: Color = Color(0xFFF2F2F2),
    shape: RoundedCornerShape = RoundedCornerShape(18.dp),
    borderColor: Color = Color(0xFFF2668B),
) {
    if (openDialog.value) {
        AlertDialog(
            modifier = Modifier
                .border(
                    width = 2.dp,
                    color = borderColor,
                    shape = RoundedCornerShape(12.dp)),
            onDismissRequest = {
                openDialog.value = false
                if (onDismiss != null) {
                    onDismiss()
                }
            },
        ) {
            Column(
                modifier = Modifier
                    .background(
                        color = color,
                        shape = shape
                    )
                    .padding(
                        32.dp
                    )
            ) {
                Text(
                    text = title
                )
                Spacer(
                    modifier = Modifier
                        .height(24.dp)
                )
                Text(
                    text = text
                )
                Spacer(
                    modifier = Modifier
                        .height(16.dp)
                )
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    DefaultButton(
                        onClick = { onConfirm() },
                        text = "Confirmar"
                    )
                    Spacer(
                        modifier = Modifier
                            .width(24.dp),
                    )
                    DefaultButton(
                        onClick = { openDialog.value = false
                            if (onDismiss != null) {
                                onDismiss()
                            }
                        },
                        text = "Cancelar"
                    )
                }
            }
        }
    }
}
