package com.example.petid

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {
    private val _pet = MutableStateFlow(PetData())
    val pet = _pet.asStateFlow()

    private val _petList = mutableStateListOf<PetData>()
    val petList: List<PetData> get() = _petList

    fun addPet(pet: PetData) {
        _pet.value = _pet.value.copy(
            name = pet.name,
            age = pet.age,
            color = pet.color,
            gender = pet.gender,
            imageUri = pet.imageUri
        )
        _petList.add(pet)
    }

    fun deletePet(pet: PetData) {
        _petList.remove(pet)
    }

    fun changeValueDeleteButton(pet: PetData) {
        if (_petList.isNotEmpty() && _petList.contains(pet)) {
            _petList.forEach { petItem ->
                petItem.showDeleteButton.value = false
            }
            pet.showDeleteButton.value = true
        }
    }

    data class PetData(
        var name: String = "",
        var age: Int = -1,
        var color: String = "",
        var gender: String = "",
        var imageUri: String? = null,
        val showDeleteButton: MutableState<Boolean> = mutableStateOf(false)
    )
}
