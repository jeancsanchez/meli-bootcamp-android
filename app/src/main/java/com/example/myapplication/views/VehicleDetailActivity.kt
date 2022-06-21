package com.example.myapplication.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityVehicleDetailBinding

class VehicleDetailActivity : AppCompatActivity() {

    private val binding: ActivityVehicleDetailBinding by lazy {
        ActivityVehicleDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val plate = intent?.extras?.getString(KEY_VEHICLE_PLATE)
        binding.textPlate.text = plate
    }

    companion object {
        const val KEY_VEHICLE_PLATE = "KEY_VEHICLE_PLATE"
    }
}