package com.example.myapplication.data

import com.example.myapplication.Dog

interface DogRepository {

    suspend fun fetchDogsList(): List<Dog>
}