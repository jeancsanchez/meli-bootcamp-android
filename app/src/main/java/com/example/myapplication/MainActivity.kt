package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.data.RemoteRepository
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val dogAdapter = DogAdapter()
    private val viewModel: MainViewModel = MainViewModel(
        repository = RemoteRepository()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvDogs.adapter = dogAdapter
        binding.rvDogs.layoutManager = GridLayoutManager(this, 3)
        viewModel.getDogs()

        viewModel.onDogsSuccess.observe(this) { dogList ->
            dogAdapter.dogList = dogList
        }
    }
}