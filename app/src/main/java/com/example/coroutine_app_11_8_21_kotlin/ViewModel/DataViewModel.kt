package com.example.coroutine_app_11_8_21_kotlin.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutine_app_11_8_21_kotlin.ModelClass.DataClass
import com.example.coroutine_app_11_8_21_kotlin.Repository.GetRepository
import kotlinx.coroutines.launch
import java.lang.Exception
import kotlin.math.log

class DataViewModel(private val getRepository: GetRepository) : ViewModel() {
    val LivedataModelList: MutableLiveData<List<DataClass>> = MutableLiveData()

    fun fatchData() {

        viewModelScope.launch {
            try {
                val result = getRepository.getPost()
                LivedataModelList.value = result
            } catch (e: Exception) {
                Log.d("myLog", "fatchData: Error ")
            }

        }
    }
}