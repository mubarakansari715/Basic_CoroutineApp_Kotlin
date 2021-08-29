package com.example.coroutine_app_11_8_21_kotlin

import com.example.coroutine_app_11_8_21_kotlin.NetworkApis.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private val url: String = "https://jsonplaceholder.typicode.com/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(url)
            .build()
    }
    val api:ApiInterface by lazy {
        retrofit.create(ApiInterface::class.java)
    }
}
