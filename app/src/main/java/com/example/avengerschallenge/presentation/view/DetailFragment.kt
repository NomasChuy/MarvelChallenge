package com.example.avengerschallenge.presentation.detailfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.avengerschallenge.databinding.FragmentDetailBinding
import com.example.avengerschallenge.databinding.FragmentMainBinding
import com.example.avengerschallenge.domain.models.MarvelDomain
import com.example.avengerschallenge.presentation.adapters.DetailAdapter
import com.example.avengerschallenge.presentation.adapters.MainAdapter
import com.example.avengerschallenge.presentation.mainfragment.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {
    lateinit var detailAdapter : DetailAdapter
    private lateinit var binding : FragmentDetailBinding
    private val viewModel by viewModels<DetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val detailTitle = arguments?.getString("detailTitle") ?: ""
        val character = arguments?.getParcelable("character") ?: MarvelDomain(emptyList(), emptyList(),"","","","")

        viewModel.setValues(detailTitle, character)

        detailAdapter = DetailAdapter()

        with(binding.rvDetail){
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)

            adapter = detailAdapter
        }

        detailAdapter.submitList(viewModel.viewDetailList)

        binding.tvTitle.text = viewModel.viewTitle
    }
}