package com.example.myapplication

import com.google.gson.annotations.SerializedName

data class Dog(
    @SerializedName("message")
    val imageUrl: String?
)