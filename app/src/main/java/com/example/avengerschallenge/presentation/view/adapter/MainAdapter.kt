package com.example.avengerschallenge.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.avengerschallenge.databinding.MainAdapterLayoutBinding
import com.example.avengerschallenge.domain.models.MarvelDomain
import com.example.avengerschallenge.core.utils.setButtonVisibility
import com.example.avengerschallenge.core.utils.setTextVisibility

class MainAdapter(val onDetailClicked:(String) -> Unit, val loadImage:(ImageView, String) -> Unit, val onSeriesClicked:(String, MarvelDomain) -> Unit) : ListAdapter<MarvelDomain, MainAdapter.MyViewHolder>(
    MarvelDiffUtil()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            MainAdapterLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hero = currentList[position]

        with(holder.card){
            loadImage(ivHeroImage, hero.image)

            tvHeroName.text = hero.name

            tvHeroDescription.setTextVisibility(hero.description)
            btnHeroSeries.setButtonVisibility(hero.series)
            btnHeroComics.setButtonVisibility(hero.comics)
            btnHeroDetails.setButtonVisibility(hero.detail)

            btnHeroSeries.setOnClickListener {
                onSeriesClicked("Series", hero)
            }

            btnHeroComics.setOnClickListener {
                onSeriesClicked("Comics", hero)
            }

            btnHeroDetails.setOnClickListener{
                onDetailClicked(hero.detail)
            }
        }
    }

    class MyViewHolder(val card: MainAdapterLayoutBinding): RecyclerView.ViewHolder(card.root)

    class MarvelDiffUtil: DiffUtil.ItemCallback<MarvelDomain>(){
        override fun areItemsTheSame(oldItem: MarvelDomain, newItem: MarvelDomain): Boolean = oldItem == newItem

        override fun areContentsTheSame(oldItem: MarvelDomain, newItem: MarvelDomain): Boolean = oldItem == newItem
    }
}