package com.example.petid

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val mainModule = module {
    viewModelOf(::MainViewModel)
}
