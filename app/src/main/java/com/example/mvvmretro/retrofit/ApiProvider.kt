package com.example.mvvmretro.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface ApiProvider {
    @GET("posts")
    fun getPosts(): Call<List<ResponseModel>>
}