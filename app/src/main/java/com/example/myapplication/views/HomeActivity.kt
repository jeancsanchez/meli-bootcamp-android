package com.example.myapplication.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityHomeBinding
import com.example.myapplication.vm.LoginViewModel

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val loginViewModel: LoginViewModel = LoginViewModel()
    private val adapter by lazy { VehicleAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.adapter = adapter
        binding.recycler.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


        loginViewModel.fetchVehicles()
        loginViewModel.vehicles.observe(this) {
            if (it.isNotEmpty()) {
                adapter.listVehicles = it
            }
        }
    }

    /**
     * Pegando informacao da tela anterior atraves de Intents
     */
    private fun getEmailFromIntent() {
        val email = intent?.extras?.getString(EMAIL_KEY)
    }

    /**
     * Pegando informacoes da tela anterior utilizando o SharedPreferences
     */
    private fun getTokenFromDisk() {
        val token = getSharedPreferences(
            "minha_aplicacao",
            MODE_PRIVATE
        ).getString("token", "")


    }

    companion object {
        const val EMAIL_KEY = "EMAIL_VALIDADO"
    }
}