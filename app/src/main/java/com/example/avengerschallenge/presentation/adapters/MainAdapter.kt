package com.example.avengerschallenge.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.avengerschallenge.R
import com.example.avengerschallenge.databinding.MainAdapterLayoutBinding
import com.example.avengerschallenge.domain.models.MarvelDomain

class MainAdapter : ListAdapter<MarvelDomain, MainAdapter.MyViewHolder>(MarvelDiffUtil) {
    inner class MyViewHolder(private val binding: MainAdapterLayoutBinding) : ViewHolder(binding.root){
        fun onBind(marvelDomain: MarvelDomain){
            Glide
                .with()//no se que vaya aqui, perdoname diego :(
                .load(marvelDomain.image)
                .optionalCenterInside()
                .placeholder(R.drawable.noimagefoundmarvel)
                .into(this)

            binding.textViewName.text = marvelDomain.name
            binding.textViewDescription.text = marvelDomain.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            MainAdapterLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(marvelDomain = currentList[position])
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