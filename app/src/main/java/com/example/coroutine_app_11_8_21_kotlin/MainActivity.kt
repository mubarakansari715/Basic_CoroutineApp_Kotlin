package com.example.coroutine_app_11_8_21_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coroutine_app_11_8_21_kotlin.Adapters.RecyAdapter
import com.example.coroutine_app_11_8_21_kotlin.ModelClass.DataClass
import com.example.coroutine_app_11_8_21_kotlin.Repository.GetRepository
import com.example.coroutine_app_11_8_21_kotlin.ViewModel.DataFractory
import com.example.coroutine_app_11_8_21_kotlin.ViewModel.DataViewModel
import kotlinx.android.synthetic.main.activity_main.*


abstract class MainActivity : AppCompatActivity() {
    private lateinit var myAdapter: RecyAdapter
    private lateinit var dataViewModel: DataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myAdapter = RecyAdapter(this, ArrayList())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = myAdapter
        }

        //calling fun
        getMyData()

    }
    //true -> Toast.makeText(this, "Connected",Toast.LENGTH_SHORT).show()
   // false -> Toast.makeText(this, "Not Connected",Toast.LENGTH_SHORT).show()

    private fun getMyData() {
        val getRepository = GetRepository()
        val dataFractory = DataFractory(getRepository)
        dataViewModel = ViewModelProvider(this, dataFractory)[DataViewModel::class.java]
        dataViewModel.fatchData()
        dataViewModel.LivedataModelList.observe(this, Observer {
            myAdapter.setData(it as List<DataClass>)
            progress_circular.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
        })
    }
}