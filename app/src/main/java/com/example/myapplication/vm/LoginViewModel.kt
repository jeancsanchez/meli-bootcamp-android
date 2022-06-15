package com.example.myapplication.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private var _isValid: MutableLiveData<Boolean> = MutableLiveData()
    val isValid: LiveData<Boolean>
        get() = _isValid

    private var _email: MutableLiveData<String> = MutableLiveData()
    val email: LiveData<String>
        get() = _email

    fun login(email: String?) {
        val result = email?.contains("@") ?: false
        _isValid.value = result
        _email.value = email
    }
}