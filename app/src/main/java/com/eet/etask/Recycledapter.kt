package com.eet.etask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Recycledapter( val posts:ArrayList<String>): RecyclerView.Adapter<Recycledapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        val View = LayoutInflater.from(parent.context).inflate(R.layout.row,parent,false)
        return ViewHolder(View)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


    }
}