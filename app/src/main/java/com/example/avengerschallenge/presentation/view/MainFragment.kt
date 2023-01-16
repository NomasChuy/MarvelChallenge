package com.example.avengerschallenge.presentation.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.avengerschallenge.R
import com.example.avengerschallenge.databinding.FragmentMainBinding
import com.example.avengerschallenge.domain.models.MarvelDomain
import com.example.avengerschallenge.presentation.view.adapter.MainAdapter
import com.example.avengerschallenge.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {
    lateinit var mainAdapter : MainAdapter
    private lateinit var binding : FragmentMainBinding
    private val viewModel by viewModel<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainAdapter = MainAdapter(::onDetailClicked, ::setImage, ::setDetailTitle)

        with(binding.rvCharactersList){
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)

            adapter = mainAdapter
        }

        setObservers()

        viewModel.getCharacterList()
    }

    private fun setObservers(){
        viewModel.characterList.observe(viewLifecycleOwner){
            mainAdapter.submitList(it)
        }
    }

    private fun navigateToDetail(character: MarvelDomain){
        val bundle = bundleOf(
            "detailTitle" to viewModel.title.value,
            "character" to character
        )

        findNavController().navigate(R.id.action_mainFragment_to_detailFragment, bundle)
    }

    private fun setDetailTitle(title: String, character: MarvelDomain){
        viewModel.setTitle(title)
        navigateToDetail(character)
    }

    private fun onDetailClicked(url: String){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    private fun setImage(view: ImageView, url: String){
        Glide
            .with(this)
            .load(url)
            .into(view)
    }
}