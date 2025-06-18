package com.example.petid

import android.net.Uri
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {
    private val _pet = MutableStateFlow(PetData())
    val pet = _pet.asStateFlow()

    private val _petList = mutableStateListOf<PetData>()
    val petList: List<PetData> get() = _petList

    fun updatePet(pet: PetData) {
        _pet.value = _pet.value.copy(
            name = pet.name,
            age = pet.age,
            color = pet.color,
            gender = pet.gender,
            imageUri = pet.imageUri
        )
        _petList.add(pet)
    }

    data class PetData(
        var name: String = "",
        var age: Int = -1,
        var color: String = "",
        var gender: String = "",
        var imageUri: String? = null
    )
}
