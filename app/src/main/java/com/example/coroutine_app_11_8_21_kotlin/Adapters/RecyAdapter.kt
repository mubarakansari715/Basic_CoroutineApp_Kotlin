package com.example.coroutine_app_11_8_21_kotlin.Adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutine_app_11_8_21_kotlin.ModelClass.DataClass
import com.example.coroutine_app_11_8_21_kotlin.R
import com.squareup.picasso.Picasso

class RecyAdapter(private val context: Context, private var dataView: List<DataClass>) :
    RecyclerView.Adapter<RecyAdapter.RecyViewHolder>() {


    class RecyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.tv_title)!!
        val img = itemView.findViewById<ImageView>(R.id.tv_imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyViewHolder {
        return RecyViewHolder(LayoutInflater.from(context)
            .inflate(R.layout.custom_view, parent, false))
    }

    override fun onBindViewHolder(holder: RecyViewHolder, position: Int) {
        val view = dataView[position]
        holder.title.text = view.title
        Picasso.get().load(view.url).fit().centerCrop().into(holder.img)
    }

    override fun getItemCount(): Int = dataView.size

    //extra add
    @SuppressLint("NotifyDataSetChanged")
    fun setData(dataView: List<DataClass>) {
        this.dataView = dataView
        notifyDataSetChanged()

    }
}