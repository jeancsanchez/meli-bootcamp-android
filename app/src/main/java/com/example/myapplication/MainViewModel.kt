package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.DogRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: DogRepository
) : ViewModel() {

    private val _onDogsSuccess: MutableLiveData<List<Dog>> = MutableLiveData()
    val onDogsSuccess: LiveData<List<Dog>>
        get() = _onDogsSuccess

    fun getDogs() = viewModelScope.launch(Dispatchers.IO) {
        val result = repository.fetchDogsList()
        _onDogsSuccess.value = result
    }
}