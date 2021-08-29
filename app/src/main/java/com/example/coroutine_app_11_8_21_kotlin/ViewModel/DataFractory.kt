package com.example.coroutine_app_11_8_21_kotlin.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.coroutine_app_11_8_21_kotlin.Repository.GetRepository

class DataFractory(private val getRepository: GetRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DataViewModel(getRepository) as T
    }
}