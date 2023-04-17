package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.MyData

class AccountTransactionsAdapter(private val data: List<MyData>):
    RecyclerView.Adapter<AccountTransactionsAdapter.CustomViewHolder>() {

    class CustomViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.icon)
        val titleTextView: TextView = itemView.findViewById(R.id.title)
        val descriptionTextView: TextView = itemView.findViewById(R.id.description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.transaction_items, parent, false)
        return CustomViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val myData = data[position]

        holder.imageView.setImageResource(myData.iconResource)
        holder.titleTextView.text = myData.title
        holder.descriptionTextView.text = myData.description
    }

    override fun getItemCount(): Int {
        return data.size
    }
}