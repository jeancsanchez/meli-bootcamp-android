package com.example.myapplication.data

import com.example.myapplication.Dog
import retrofit2.Call
import retrofit2.http.GET

interface DogsAPI {

    @GET("/api/breeds/image/random")
    fun fetchDogs(): Call<Dog>
}