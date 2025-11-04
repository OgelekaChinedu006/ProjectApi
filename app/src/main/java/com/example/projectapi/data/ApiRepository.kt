package com.example.projectapi.data

import com.example.projectapi.Model.Post
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Repository{

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/") // base endpoint
        .addConverterFactory(GsonConverterFactory.create()) // convert JSON to Kotlin
        .build()

    private val api  = retrofit.create(ApiService::class.java)

    suspend fun getPosts(): List<Post> = api.getPosts()
}