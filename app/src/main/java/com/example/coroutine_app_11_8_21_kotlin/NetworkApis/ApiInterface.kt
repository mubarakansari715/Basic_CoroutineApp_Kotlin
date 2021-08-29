package com.example.coroutine_app_11_8_21_kotlin.NetworkApis

import com.example.coroutine_app_11_8_21_kotlin.ModelClass.DataClass
import retrofit2.http.GET

interface ApiInterface {

    @GET("photos")
    suspend fun getData() : List<DataClass>
}