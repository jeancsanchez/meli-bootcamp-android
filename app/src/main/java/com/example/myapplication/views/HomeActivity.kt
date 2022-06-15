package com.example.myapplication.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityHomeBinding
import com.example.myapplication.vm.LoginViewModel

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private val viewModel: LoginViewModel = LoginViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email = intent?.extras?.getString(EMAIL_KEY)
        binding.title.text = email
    }

    companion object {
        const val EMAIL_KEY = "EMAIL_VALIDADO"
    }
}