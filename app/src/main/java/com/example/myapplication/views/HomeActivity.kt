package com.example.myapplication.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityHomeBinding
import com.example.myapplication.vm.LoginViewModel

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getTokenFromDisk()
        getEmailFromIntent()
    }

    /**
     * Pegando informacao da tela anterior atraves de Intents
     */
    private fun getEmailFromIntent() {
        val email = intent?.extras?.getString(EMAIL_KEY)
        binding.title.text = email
    }

    /**
     * Pegando informacoes da tela anterior utilizando o SharedPreferences
     */
    private fun getTokenFromDisk() {
        val token = getSharedPreferences(
            "minha_aplicacao",
            MODE_PRIVATE
        ).getString("token", "")

        val emailText = binding.title.text.toString()
        val newText = "Email: $emailText\nToken: $token"
        binding.title.text = newText
    }

    companion object {
        const val EMAIL_KEY = "EMAIL_VALIDADO"
    }
}