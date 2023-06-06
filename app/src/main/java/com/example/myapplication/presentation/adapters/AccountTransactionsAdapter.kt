package com.example.myapplication.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.domain.models.DomainPost
import com.example.myapplication.presentation.fragments.PostsFragment

class AccountTransactionsAdapter(
    private val context: PostsFragment,
    private val items: List<DomainPost>,
    private val event: (View) -> Unit
    ):
    RecyclerView.Adapter<AccountTransactionsAdapter.CustomViewHolder>(){

     class CustomViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.icon)
        val titleTextView: TextView = itemView.findViewById(R.id.title)
        val publishedAtTextView: TextView = itemView.findViewById(R.id.publishedAt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.transaction_items, parent, false)

        itemView.setOnClickListener {
            event(it)
        }
        return CustomViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.apply {
            titleTextView.text = items[position].title
            publishedAtTextView.text = items[position].publishedAt
        }
        Glide
            .with(context)
            .load(items[position].urlToImage)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}