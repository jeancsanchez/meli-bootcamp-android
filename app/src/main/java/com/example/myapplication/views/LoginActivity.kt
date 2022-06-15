package com.example.myapplication.views

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityLoginBinding
import com.example.myapplication.vm.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    private val viewModel: LoginViewModel = LoginViewModel()

    // Criando
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            val email = binding.edtEmail.text?.toString()
            viewModel.login(email)
        }

        viewModel.isValid.observe(this) { isValid ->
            if (isValid) {
                showHome()
            } else {
               showMessageError()
            }
        }
    }

    private fun showMessageError() {
        Toast.makeText(this, "Email invalido", Toast.LENGTH_LONG).show()
    }

    private fun showHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}