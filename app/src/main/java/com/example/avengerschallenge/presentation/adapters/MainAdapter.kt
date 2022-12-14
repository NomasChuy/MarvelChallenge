package com.example.avengerschallenge.presentation

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.avengerschallenge.databinding.AdapterLayoutBinding
import com.example.avengerschallenge.domain.models.MarvelDomain

class MainAdapter : ListAdapter<MarvelDomain, MainAdapter.MyViewHolder>(MarvelDiffUtil) {
    inner class MyViewHolder(private val binding : AdapterLayoutBinding) : ViewHolder(binding.root){
        fun onBind(marvelDomain: MarvelDomain){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO()
    }
}

object MarvelDiffUtil : DiffUtil.ItemCallback<MarvelDomain>(){
    override fun areItemsTheSame(oldItem: MarvelDomain, newItem: MarvelDomain): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: MarvelDomain, newItem: MarvelDomain): Boolean {
        return oldItem == newItem
    }
}