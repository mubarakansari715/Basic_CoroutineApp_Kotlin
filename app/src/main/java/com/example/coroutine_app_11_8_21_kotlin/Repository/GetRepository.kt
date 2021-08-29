package com.example.coroutine_app_11_8_21_kotlin.Repository

import com.example.coroutine_app_11_8_21_kotlin.ModelClass.DataClass
import com.example.coroutine_app_11_8_21_kotlin.RetrofitBuilder

class GetRepository {
    suspend fun getPost(): List<DataClass> = RetrofitBuilder.api.getData()
}