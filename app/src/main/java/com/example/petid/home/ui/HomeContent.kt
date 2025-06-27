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
import com.example.petid.components.DefaultButton
import com.example.petid.navigation.Routes.FORM
import com.example.petid.navigation.Routes.PET_LIST

@Composable
fun HomeContent(
    navController: NavController? = null
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)

    ) {
        DefaultButton(
            onClick = {
                navController?.navigate(FORM)
            },
            text = "form"
        )

        DefaultButton(
            onClick = {
                navController?.navigate(PET_LIST)
            },
            text = "pet_list"
        )
    }

}

@Preview
@Composable
fun HomeContentPreview() {
    HomeContent()
}