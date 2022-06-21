package com.example.myapplication.views

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityLoginBinding
import com.example.myapplication.vm.LoginViewModel
import java.lang.reflect.Type

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

    fun showHome() {
        saveTokenInDisk()

        val intent = Intent(this, HomeActivity::class.java)
        intent.putExtra(HomeActivity.EMAIL_KEY, binding.edtEmail.text?.toString())
        startActivity(intent)
    }

    private fun saveTokenInDisk() {
        getSharedPreferences(SHARED_PREFERENCES_NAME, MODE_PRIVATE)
            .edit()
            .putString(SHARED_PREFERENCES_TOKEN_KEY, "123j4k134kl14j12l34j")
            .apply()
    }

    companion object {
        const val SHARED_PREFERENCES_NAME = "Some_cool_name"
        const val SHARED_PREFERENCES_TOKEN_KEY = "token"
    }
}