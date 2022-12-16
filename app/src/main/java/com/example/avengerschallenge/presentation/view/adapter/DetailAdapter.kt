package com.example.avengerschallenge.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.avengerschallenge.databinding.DetailAdapterLayoutBinding

class DetailAdapter(): ListAdapter<String, DetailAdapter.MyViewHolder>(DetailDiffUtil()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            DetailAdapterLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = currentList[position]

        with(holder.card){
            textViewComicOrSeries.text = item.toString()
        }
    }

    class MyViewHolder(val card: DetailAdapterLayoutBinding): RecyclerView.ViewHolder(card.root)

    class DetailDiffUtil: DiffUtil.ItemCallback<String>(){
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem
    }
}