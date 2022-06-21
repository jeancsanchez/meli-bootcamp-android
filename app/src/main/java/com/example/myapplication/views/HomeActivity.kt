package com.example.myapplication.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
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
        binding.recycler.layoutManager = GridLayoutManager(this, 3)

        adapter.itemClicked = VehicleAdapter.OnItemClicked {
            val intent = Intent(this, VehicleDetailActivity::class.java)
            intent.putExtra(VehicleDetailActivity.KEY_VEHICLE_PLATE, it.plate)
            startActivity(intent)
        }

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