package com.example.myapplication.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.Vehicle
import com.example.myapplication.networking.ParkingService

class LoginViewModel : ViewModel() {

    private var _isValid: MutableLiveData<Boolean> = MutableLiveData()
    val isValid: LiveData<Boolean>
        get() = _isValid

    private var _vehicles: MutableLiveData<List<Vehicle>> = MutableLiveData()
    val vehicles: LiveData<List<Vehicle>>
        get() = _vehicles

    fun login(email: String?) {
        val result = email?.contains("@") ?: false
        _isValid.value = result
    }

    fun fetchVehicles() {
        val result = ParkingService.getVehicles()
        _vehicles.value = result
    }
}