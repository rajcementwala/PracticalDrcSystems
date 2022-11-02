package com.example.practicaldrcsystems.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practicaldrcsystems.R
import com.example.practicaldrcsystems.databinding.ItemLayoutTransactionsBinding

class TransactionAdapter : RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {

       return TransactionViewHolder(ItemLayoutTransactionsBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {

        holder.setItem();
    }

    override fun getItemCount(): Int {
        return 0
    }
    inner class TransactionViewHolder(binding:ItemLayoutTransactionsBinding):RecyclerView.ViewHolder(binding.root){

        fun setItem(){

        }


    }
}