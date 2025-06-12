package com.example.petid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.petid.navigation.NavHost
import com.example.petid.ui.theme.PetIDTheme
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupKoin()
        setContent {
            PetIDTheme {
                NavHost(context = applicationContext)
            }
        }
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@MainActivity)
            modules(mainModule)
        }
    }
}

