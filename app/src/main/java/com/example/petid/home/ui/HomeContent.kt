package com.example.petid.home.ui

import android.graphics.BitmapFactory
import android.util.Size
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.example.petid.R

@Composable
fun HomeContent() {
    val context = LocalContext.current
    val imageBitmap = BitmapFactory.decodeResource(context.resources, R.drawable.img_unicesumar_frente)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .drawBehind {
                drawImage(
                    imageBitmap.asImageBitmap(),
                    dstSize = IntSize(size.width.toInt(), (size.height * 0.79f).toInt()),
                    dstOffset = IntOffset(0, 224)
                )
            }
    ) {
        Text(
            modifier = Modifier.rotate(270f),
            text = "CARTEIRA DE IDENTIFICAÇÃO ESTUDANTIL",
            fontWeight = FontWeight.Bold
        )

        Text(
            modifier = Modifier.rotate(270f),
            text = "Nome",
            fontWeight = FontWeight.Bold
        )

        Text(
            modifier = Modifier.rotate(270f),
            text = "Fernanda Bordin de Souza"
        )
    }

    Row(
      modifier = Modifier
          .padding(16.dp)
          .fillMaxWidth(),
        horizontalArrangement = Arrangement.End

    ) {
        Icon(
            modifier = Modifier
                .size(32.dp)
                .drawBehind {
                    drawCircle(
                        color = Color.Gray,
                        radius = 60f
                    )
                },
            imageVector = Icons.Filled.Clear,
            contentDescription = null,
            tint = Color.White        )
    }


}