package com.example.projectapi.data

import com.example.projectapi.Model.Post
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): List<Post>


}