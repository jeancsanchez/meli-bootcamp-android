package com.example.myapplication.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private var _isValid: MutableLiveData<Boolean> = MutableLiveData()
    val isValid: LiveData<Boolean>
        get() = _isValid

    fun login(email: String?) {
        val result = email?.contains("@") ?: false
        _isValid.value = result
    }
}