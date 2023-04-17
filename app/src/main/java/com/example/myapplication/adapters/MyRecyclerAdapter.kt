package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class MyRecyclerAdapter(private val items: List<String>):
    RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.recyclerView_item_1)
        val descriptionTextView: TextView = itemView.findViewById(R.id.recyclerView_item_2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.recycler_items, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.titleTextView.text = items[position]
        holder.descriptionTextView.text = "item info"
    }

    override fun getItemCount(): Int {
        return items.size
    }
}