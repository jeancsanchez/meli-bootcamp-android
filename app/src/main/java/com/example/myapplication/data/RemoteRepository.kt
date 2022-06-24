package com.example.myapplication.data

import com.example.myapplication.Dog
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteRepository : DogRepository {

    private val retrofit = Retrofit.Builder()
        .baseUrl(API_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api: DogsAPI by lazy {
        retrofit.create(DogsAPI::class.java)
    }

    override suspend fun fetchDogsList(): List<Dog> {
        val dogsList = mutableListOf<Dog>()

        for (i in 0..10) {
            val response = api.fetchDogs().execute()

            if (response.isSuccessful && response.body() != null) {
                response.body()?.let {
                    dogsList.add(it)
                }
            }
        }

        return dogsList
    }

    companion object {
        private const val API_BASE_URL = "https://dog.ceo/"
    }
}