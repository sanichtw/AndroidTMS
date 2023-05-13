package com.example.myapplication.presentation.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.domain.models.DomainPaymentList

class AccountTransactionsAdapter(
    private val items: DomainPaymentList,
    private val event: (View) -> Unit
    ):
    RecyclerView.Adapter<AccountTransactionsAdapter.CustomViewHolder>(){

     class CustomViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.icon)
        val titleTextView: TextView = itemView.findViewById(R.id.title)
        val descriptionTextView: TextView = itemView.findViewById(R.id.description)
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
        val payment = items.payments[position]

        holder.imageView.setImageResource(payment.image)
        holder.titleTextView.text = payment.title
        holder.descriptionTextView.text = payment.description
    }

    override fun getItemCount(): Int {
        return items.payments.size
    }
}