package com.example.petid.home.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.petid.navigation.Routes.FORM

@Composable
fun HomeContent(
    navController: NavController? = null
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)

    ) {
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                navController?.navigate(FORM)
            },
            content = {
                Text(text = "form")
            }
        )

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {},
            content = {
                Text(text = "pet_list")
            }
        )
    }

}

@Preview
@Composable
fun HomeContentPreview() {
    HomeContent()
}